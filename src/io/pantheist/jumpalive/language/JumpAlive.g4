grammar JumpAlive;

sourceFile: classDef EOF;

classDef: 'class' ID '{' classStatement* '}';

classStatement: implementsStatement;

implementsStatement: 'implements' ID '{' statement* '}';



statement: returnStatement;

returnStatement: 'return' expr ';';


expr: emptyListExpr | listExpr | stringExpr;

emptyListExpr: '[' ']';

listExpr: '[' expr (',' expr)* ']';

stringExpr: STRING;


STRING: '"' ~[\r\n"\\]* '"';

ID: [a-z]+ ;

WS: [ \t\r\n]+ -> skip;
