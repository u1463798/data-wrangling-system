import json
import pandas as pd
import sys
from datetime import date as date_

def date(datestr):
    parts = datestr.split(' ')
    return parts[0]

def time(datestr):
    parts = datestr.split(' ')
    return parts[1]

def dayofweek(datestr):
    parts = datestr.split('/')
    ans = date_(int(parts[0]), int(parts[1]), int(parts[2])).weekday()
    return ans

def runner(file):
    data_frames = {}
    operators = {}
    with open(file, "r") as read_file:
        data = json.load(read_file)
    functions = resolve_imports(data)
    functions["date"] = date
    functions["time"] = time
    functions["dayofweek"] = dayofweek
    functions["avg"] = avg
    functions["jt"] = jt
    functions["enrich_timestamp"] = enrich_timestamp
    grouping_function = None
    sequence = data["sequence"]
    for operator in data["operators"]:
        operators[operator["id"]] = operator
    for i in sequence:
        operator = operators[i]
        name = operator["operator"]
        if name == "read":
            read(operator, data_frames)
        elif name == "select":
            select(operator, data_frames, functions)
        elif name == "wrangling":
            function_name = operator["function_name"]
            wrangling(operator, data_frames, functions)
        elif name == "union":
            union(operator, data_frames)
        elif name == "join":
            join(operator, data_frames)
        elif name == "project":
            project(operator, data_frames, functions)
        elif name == "write":
            write(operator, data_frames, functions)
        elif name == "spatial_temporal_join":
            spatial_temporal_join(operator, frames)
        elif name == "group_by":
            grouping_function = group_by(operator, frames)

def resolve_imports(data):
    imports = data["imports"]
    functions = {}
    for imp in imports:
        name = imp.lower()
        module = __import__(name)
        func = getattr(module, name)
        functions[name] = func
    return functions

def read(read_op, frames):
    filename = read_op["file"]["name"]
    alias = read_op["file"]["alias"]
    frame = None
    if ".csv" in filename:
        frame = pd.read_csv(filename)
    elif ".json" in filename:
        with open(filename, 'r') as f:
                frame = json.load(f)
    frames[alias] = frame

def select(select_op, frames, functions):
    file = select_op["file"]
    conditions = select_op["conditions"]
    for condition in conditions:
        frame = frames[file]
        if condition["type"] == "simple":
            if condition["left"]["type"] == "column" and condition["right"]["type"] == "literal":
                column = condition["left"]["value"]["column"].replace("_", " ")
                literal = condition["right"]["value"].replace("'", "")
                if condition["comparison"] == "=":
                    new_frame = None
                    if literal.isdigit():
                        new_frame = frame[frame[column] == int(literal)]
                    else:
                        new_frame = frame[frame[column] == literal]
                    frames[file] = new_frame
            elif condition["left"]["type"] == "function" and condition["right"]["type"] == "literal":
                first_function = condition["left"]["value"]["name"].lower()
                second_function = None
                argument = None
                if condition["left"]["value"]["arguments"][0]["type"] == "function":
                    second_function = condition["left"]["value"]["arguments"][0]["value"]["name"].lower()
                    argument = condition["left"]["value"]["arguments"][0]["value"]["arguments"][0]["value"]["column"]
                else:
                    argument = condition["left"]["value"]["arguments"][0]["value"]["column"]
                literal = condition["right"]["value"].replace("'", "")
                column = argument
                if second_function is None:
                    new_frame = None
                    if condition["comparison"] == "=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](a)) == literal))]
                    elif condition["comparison"] == "<":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](a)) < literal))]
                    elif condition["comparison"] == ">":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](a)) > literal))]
                    elif condition["comparison"] == "<=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](a)) <= literal))]
                    elif condition["comparison"] == ">=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](a)) >= literal))]
                    frames[file] = new_frame
                else:
                    new_frame = None
                    if condition["comparison"] == "=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](functions[second_function](a))) == literal))]
                    elif condition["comparison"] == "<":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](functions[second_function](a))) < literal))]
                    elif condition["comparison"] == ">":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](functions[second_function](a))) > literal))]
                    elif condition["comparison"] == "<=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](functions[second_function](a))) <= literal))]
                    elif condition["comparison"] == ">=":
                        new_frame = frame[frame[column].map(lambda a : (str(functions[first_function](functions[second_function](a))) >= literal))]
                    frames[file] = new_frame

def enrich_timestamp(operator, frames):
    file = operator["arguments"][0]["value"]["file"]
    column = operator["arguments"][0]["value"]["column"]
    frame = frames[file]
    pattern = operator["arguments"][1]["value"]
    start = 0
    if len(operator["arguments"]) >= 3:
        start = operator["arguments"][2]["value"]
    separator_index = pattern.index("d")
    separator = pattern[separator_index+1]
    if start == 0:
        enhanced_enrich(operator, frames)
        return
    frame[column] = frame[column].map(lambda a : enrich(a, separator))

def union(operator, frames):
    first = operator["first"]
    second = operator["second"]
    file1 = frames[first]
    file2 = frames[second]
    files = [file1, file2]
    new_frame = pd.concat(files)
    frames[first] = new_frame
    frames[second] = new_frame

def join(operator, frames):
    files = operator["files"]
    file_frames = []
    if frames[files[0]] is frames[files[1]]:
        conditions = operator["key"]["conditions"]
        results = []
        for condition in conditions:
            file1 = condition["left"]["value"]["file"]
            column1 = condition["left"]["value"]["column"].replace("_", " ")
            file2 = condition["right"]["value"]["file"]
            column2 = condition["right"]["value"]["column"].replace("_", " ")
            frame1 = frames[file1]
            frame2 = frames[file2]
            #frame2.rename(columns={column2:column1}, inplace=True)
            frame1[column1] = frame1[column1].map(lambda a : last_4(a))
            frame1[column1] = frame1[column1].astype("int64")
            result = frame1.merge(frame2, left_on = column1, right_on = column2)
            results.append(result)
        res = pd.concat(results)
        for file in files:
            frames[file] = res

def spatial_temporal_join(operator, frames):
    files = operator["files"]
    file_frames = []
    conditions = operator["conditions"]
    #needs completion

def group_by(operator, frames):
    grouping_function = operator["function"]
    return grouping_function

def project(operator, frames, functions):
    columns = operator["columns"]
    new_cols = []
    for col in columns:
        col = col.replace("_", " ")
        parts = col.split(" ")
        if len(parts) == 2:
            new_col = col.split(" ")[0] + " (" + col.split(" ")[1] + ")"
            new_cols.append(new_col)
        else:
            new_cols.append(col)
    iter = frames.itervalues()
    frame = iter.next()
    frame = frame.loc[:, new_cols]
    for k, v in frames.iteritems():
        frames[k] = frame

def write(operator, frames, functions):
    iter = frames.itervalues()
    frame = iter.next()
    function = operator["function"]["name"].lower()
    arguments = operator["function"]["arguments"]
    args = []
    for arg in arguments:
        if arg["type"] == "literal":
            val = arg["value"]
            num = avg(val, frame)
            args.append(num)
        else:
            inner_function = arg["value"]["name"].lower()
            inner_arg_raw = arg["value"]["arguments"][0]["value"].replace("_", " ")
            inner_arg = inner_arg_raw.split(" ")[0] + " (" + inner_arg_raw.split(" ")[1] + ")"
            res = functions[inner_function](inner_arg, frame)
            args.append(res)
    final_result = functions[function](args[0], args[1])
    res = round(final_result, 2)
    file_name = operator["file"]
    d = {res}
    frame = pd.DataFrame(d, columns=["Journey Time (hrs)"])
    frame.to_csv(file_name)

def wrangling(operator, frames, functions):
    function_name = operator["function_name"].lower()
    functions[function_name](operator, frames)

def enrich(str, separator, additional = False, to_add = ""):
    if additional:
        str.replace("-", separator)
        str = str[:-1]
        str = str + " " + to_add
        return str
    else :
        str = str.replace("-", separator)
        str = str.split(".")[0]
        return str

def enhanced_enrich(operator, frames):
    #for future use
    file = operator["arguments"][0]["value"]["file"]
    column = operator["arguments"][0]["value"]["column"]
    frame = frames[file]
    pattern = operator["arguments"][1]["value"]
    start = 0
    if len(operator["arguments"]) >= 3:
        start = operator["arguments"][2]["value"]
    separator_index = pattern.index("d")
    separator = pattern[separator_index+1]
    offset = frame["$"]
    for index, row in frame.iterrows():
        row[column] = enrich(row[column], separator, True, str(int(row["$"])/60))

def last_4(arg):
    string = str(arg)
    string = string[-4:]
    return string

def avg(col, frame):
    ans = frame.loc[:,col].mean()
    return ans

def jt(len, avg_speed):
    return float(len) / avg_speed

runner(sys.argv[1])
