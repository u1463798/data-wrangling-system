grammar D2wl;

/*Parser rules*/

query: import_list? select_clause from_clause to_clause where_clause wrangle_clause group_clause? SCOL;

group_clause: GROUP BY function_call;

wrangle_clause: WRANGLE BY wrangle_list;

wrangle_list: wrangle_operation (COMMA wrangle_operation)*;

wrangle_operation: function_call | union_operation | spatial_join;

union_operation: OPEN_PAR file_name UNION file_name CLOSE_PAR;

spatial_join: OPEN_PAR file_name JOIN file_name ON OPEN_PAR atom_list CLOSE_PAR CLOSE_PAR AS file_name;

atom_list: atom (AND atom)*;

file_name: any_name;

where_clause: WHERE condition_list;

condition_list: formula (AND condition_list)?;

formula: atom | disjunction;

atom: left_operand comparison_operator right_operand;

disjunction: OPEN_PAR atom OR atom CLOSE_PAR;

left_operand: function_call | table_column;

right_operand: function_call | table_column | literal_value;

literal_value: quoted_numeric_literal | TIME_LITERAL | STRING_LITERAL;

quoted_numeric_literal: '\'' NUMERIC_LITERAL '\'';

table_column: table_name DOT column_name;

comparison_operator: EQ | GT_EQ | LT_EQ | LT | GT | TILDE;

to_clause: TO to_location;

to_location: url;

from_clause: FROM from_list;

from_list: from_location (COMMA from_location)*;

from_location: url AS name_alias;

select_clause: SELECT select_argument;

select_argument: function_call;

function_call: function_name OPEN_PAR function_argument (COMMA function_argument)* CLOSE_PAR;

function_argument: function_call | table_column | literal_argument;

literal_argument: any_name | OPEN_PAR (any_name (COMMA any_name)*) CLOSE_PAR;

import_list: IMPORT imported_function (IMPORT imported_function)*;

imported_function: any_name;

url: name DOT extension;

extension: name;

name_alias: name;

column_name: any_name;

table_name: any_name;

name
 : any_name
 ;

function_name
 : any_name
 ;

any_name
 : IDENTIFIER
 | keyword
 | STRING_LITERAL
 | '(' any_name ')'
 | any_name DOT any_name
 ;

keyword: SELECT | FROM | TO | WHERE | WRANGLE | GROUP | BY | AS | AND | OR | JOIN | ON;

/*Lexer Rules*/

SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
COMMA : ',';
EQ : '=';
STAR : '*';
PLUS : '+';
MINUS : '-';
TILDE : '~';
PIPE2 : '||';
DIV : '/';
MOD : '%';
LT2 : '<<';
GT2 : '>>';
AMP : '&';
PIPE : '|';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
NOT_EQ1 : '!=';
NOT_EQ2 : '<>';

SELECT    : S E L E C T ;
FROM      : F R O M ;
TO        : T O ;
WHERE     : W H E R E ;
WRANGLE   : W R A N G L E;
GROUP     : G R O U P;
BY        : B Y;
AS        : A S;
AND       : A N D;
OR        : O R;
UNION     : U N I O N;
JOIN      : J O I N;
ON        : O N;
IMPORT    : I M P O R T;

IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]*;

TIME_LITERAL: '\'' DIGIT DIGIT COL DIGIT DIGIT COL DIGIT DIGIT '\'';
COL : ':';
NUMERIC_LITERAL : DIGIT+ ( '.' DIGIT*)? (E [-+]? DIGIT+ )? | '.' DIGIT+ (E [-+]? DIGIT+ )?;
STRING_LITERAL : '\'' (~ '\'' | '\'\'')* '\'';
SPACES : [ \u000B\t\r\n] -> channel(HIDDEN);

fragment DIGIT: [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];
