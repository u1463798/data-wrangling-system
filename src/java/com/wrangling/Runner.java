package com.wrangling;
import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.wrangling.mapper.QueryMapper;
import com.wrangling.models.Query;
import com.wrangling.operators.RelationalExpression;
import com.wrangling.parser.VisitorParser;

public class Runner {
    public static void main(String[] args) throws Exception{
        String q1 =
                "SELECT JT(LinkLength, AVG(Speed_mph))\n" +
                        "FROM rawpvr_2018_02_01_28d_1083.csv as f1,\n" +
                        "     rawpvr_2018_02_01_28d_1415.csv as f2,\n" +
                        "     staticSitesInfo.csv as f3\n" +
                        "TO   example_1_results.csv\n" +
                        "WHERE f1.Direction_Name = 'North' AND\n" +
                        "      DAYOFWEEK(DATE(f1.Date)) = '4' AND\n" +
                        "      TIME(f1.Date) >= '17:00:00' AND TIME(f1.Date) < '18:00:00' AND\n" +
                        "      f2.Direction_Name = 'NorthEast' AND\n" +
                        "      DAYOFWEEK(DATE(f2.Date)) = '4' AND\n" +
                        "      TIME(f2.Date) >= '17:00:00' AND TIME(f2.Date) < '18:00:00' AND\n" +
                        "      (f1.Site_ID = f3.StartSite OR f2.Site_ID = f3.EndSite) AND\n" +
                        "      f3.StartSite = '1083' AND f3.EndSite = '1415'\n" +
                        "WRANGLE BY ENRICH_TIMESTAMP(f1.Date, '%d/%c/%Y %H:%i:%s', \"01/02/2018\"),\n" +
                        "           ENRICH_TIMESTAMP(f2.Date, '%d/%c/%Y %H:%i:%s', \"01/02/2018\"),\n" +
                        "           (f1 UNION f2);";

        String q2 = "SELECT PLOT(\"bar\", AVG(f1.Speed_in_MPH), \"Hourly Avg Speeds\", (\n" +
                "    \"00:00\", \"01:00\", \"02:00\", \"03:00\", \"04:00\", \"05:00\", \"06:00\", \"07:00\", \"08:00\", \"09:00\", \"10:00\", \"11:00\",\n" +
                "    \"12:00\", \"13:00\", \"14:00\", \"15:00\", \"16:00\", \"17:00\", \"18:00\", \"19:00\", \"20:00\", \"21:00\", \"22:00\", \"23:00\"))\n" +
                "FROM rawpvr_2018_02_01_28d_1083.csv as f1,\n" +
                "     StaticSitesInfo.csv as f2,\n" +
                "     weatherUK.json as f3\n" +
                "TO   example_2_results.pdf\n" +
                "WHERE f1.Direction_Name = 'North' AND\n" +
                "      DAYOFWEEK(DATE(f1.Date)) = '6' AND\n" +
                "      f1.Site_ID = f2.StartSite_ID AND\n" +
                "      f3.W = 'wet'\n" +
                "WRANGLE BY TRANSFORM(f3, json, csv),\n" +
                "           ENRICH_TIMESTAMP(f1.Date, '%d/%c/%Y %H', \"01/02/2018\"),\n" +
                "           ENRICH_TIMESTAMP(f3.period, '%d/%c/%Y %H'),\n" +
                "           (f1 JOIN f3 ON (f1.Latitude ~ f3.lat AND\n" +
                "                           f1.Longitude ~ f3.lon AND\n" +
                "                           DATE(f1.Date) = DATE(f3.period) AND\n" +
                "                           TIME(f1.Date) ~ TIME(f3.period))) as f4\n" +
                "GROUP BY TIME(f1.Date);";

        String q3 = "IMPORT TRANSFORM \n" +
                "SELECT PLOT(\"bar\", TIME(f1.Date), AVG(f1.Speed_in_MPH))\n" +
                "FROM rawpvr_2018_02_01_28d_1083.csv as f1,\n" +
                "     StaticSitesInfo.csv as f2,\n" +
                "     weatherUK.json as f3\n" +
                "TO   example_2_results.pdf\n" +
                "WHERE f1.Direction_Name = 'North' AND\n" +
                "      DAYOFWEEK(DATE(f1.Date)) = '6' AND\n" +
                "      f1.Site_ID = f2.StartSite_ID AND\n" +
                "      f3.W >= '7'\n" +
                "WRANGLE BY TRANSFORM(f3, \"json\", \"csv\"),\n" +
                "           ENRICH_TIMESTAMP(f1.Date, '%d/%c/%Y %H', \"01/02/2018\"),\n" +
                "           ENRICH_TIMESTAMP(f3.Period.value, '%d/%c/%Y %H'),\n" +
                "           (f1 JOIN f3 ON (f1.Latitude ~ f3.lat AND\n" +
                "                           f1.Longitude ~ f3.lon AND\n" +
                "                           DATE(f1.Date) = DATE(f3.value) AND\n" +
                "                           TIME(f1.Date) ~ TIME(f3.value))) as f4\n" +
                "GROUP BY TIME(f1.Date);";

//        BufferedReader br = new BufferedReader(new FileReader(args[0]));
//        StringBuilder sb = new StringBuilder();
//        String line = br.readLine();
//        while (line != null) {
//            sb.append(line);
//            sb.append("\n");
//            line = br.readLine();
//        }
//        String everything = sb.toString();
//        br.close();
        VisitorParser visitorParser = new VisitorParser();
        Query query = visitorParser.parse(q1);
        QueryMapper queryMapper = new QueryMapper();
        RelationalExpression relationalExpression = queryMapper.mapQuery(query);
        JsonObject json =relationalExpression.getJson(null);
        
        String name = json.get("query").getAsString();
        System.out.println(json.toString());
    }
}
