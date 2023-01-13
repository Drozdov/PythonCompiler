grammar Python;

@lexer::header {
package ru.ifmo.ctddev.drozdov.python.parsing;
}

@parser::header {
package ru.ifmo.ctddev.drozdov.python.parsing;

import java.util.List;
import java.util.ArrayList;
}

@lexer::members {
	
private int previousIndents = 0;
private int indentLevel = 0;
java.util.Queue<Token> tokens = new java.util.LinkedList<Token>();

@Override
public void emit(Token t) {
	state.token = t;
	tokens.offer(t);
}
	
@Override
public Token nextToken() {
	var res = super.nextToken();
	return tokens.isEmpty() ? res : tokens.poll();
}
	
private void jump(int ttype) {
	indentLevel += (ttype == DEDENT ? -1 : 1);
	emit(new CommonToken(ttype, "level=" + indentLevel));
}
}

@parser::members {

/**
 * Common interface for python interpreter/compiler
 */
public interface ParsingManager {

	/**
	 * Gets a new variable for current operation
	 * 
	 * @param option
	 *            string representing the current operation (example: "+",
	 *            "not", etc)
	 * @param id1
	 *            first variable id
	 * @param id2
	 *            second variable id
	 * @throws RecognitionException
	 *             if operation is not successful
	 * @returns a new id for a new variable
	 */
	public int getVariable(String option, int id1, int id2)
			throws RecognitionException;

	/**
	 * Gets a new variable for a new local temporary variable
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 * @returns a new id for a new variable
	 */
	public int getVariable(Object value) throws RecognitionException;

	/**
	 * Gets a variable by its name
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 * @returns variable id
	 */
	public int getVariableByName(String name) throws RecognitionException;

	/**
	 * Gets a new temporary variable id for a value returned by a function
	 * 
	 * @param functionName
	 *            name of a function
	 * @param args
	 *            function arguments
	 * @throws RecognitionException
	 *             if operation is not successful
	 * @returns a new variable identifier
	 */
	public int getVariableByFunctionCall(String functionName,
			List<Integer> args) throws RecognitionException;

	/**
	 * Denotes that a block for function declaration starts
	 * 
	 * @param functionName
	 *            name of a function
	 * 
	 * @param args
	 *            function arguments
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void startFunctionDeclaration(String functionName,
			List<String> args) throws RecognitionException;

	/**
	 * Denotes that current function declaration is over
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void endFunctionDeclaration() throws RecognitionException;


	/**
	 * Signalizes that result of a function was returned
	 * 
	 * @param id
	 *            returned variable id
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
    public void returnStatement(int id) throws RecognitionException;

	/**
	 * Prints value by its id
	 * 
	 * @param id
	 *            variable identifier
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void print(int id) throws RecognitionException;

	/**
	 * Assigns value got by its identifier to a variable by its name
	 * 
	 * @param strId
	 *            variable name
	 * @param id
	 *            identifier where the value is stored
	 * @throws RecognitionException
	 *             if operation is not successful
	 * @returns identifier of strId variable
	 */
	public void assign(String strId, int id) throws RecognitionException;

	/**
	 * Denotes the beginning of a new cycle
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void startCycle() throws RecognitionException;

	/**
	 * Denotes the end of a current cycle
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void stopCycle() throws RecognitionException;

	/**
	 * Denotes the break of a current cycle
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void breakCycle() throws RecognitionException;

	/**
	 * Denotes that current cycle should be continued from the beginning
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void continueCycle() throws RecognitionException;

	/**
	 * Denotes that a new 'if block' is started
	 * 
	 * @param condition
	 *            identifier which references boolean value
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void startIf(int condition) throws RecognitionException;

	/**
	 * Denotes that a new 'else block' is started
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void startElse() throws RecognitionException;
	
	/**
	 * Denotes that a new 'elif block' is started
	 * IMPORTANT! This call should be done only after <code>startElse()</code> call
	 * and after condition has already been calculated
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void startElif(int condition) throws RecognitionException;

	/**
	 * Denotes that current 'if block' is over
	 * 
	 * @throws RecognitionException
	 *             if operation is not successful
	 */
	public void stopIf() throws RecognitionException;
}
    
private ParsingManager v;
    
public void setManager(ParsingManager manager) {
  	this.v = manager;
}

private static String getStr(String str) {
	return str.substring(1, str.length() - 1);
}
	
}

/* Rules */

parse	: 	NL* (atom | decl)+ EOF
 	 	;

atom	:	simple_atom | construction
		;
		
constr_atom
		:	simple_atom | NL block
		;
		
simple_atom 
		:	simple (NL | EOF)
		;	

simple	:	'pass'
		|	'print' e=expr {if (v != null) v.print($e.value);}
		|	ID '=' e=expr {if (v != null) v.assign($ID.text, $e.value);}
		|	'break' {if (v != null) v.breakCycle();}
		|	'continue' {if (v != null) v.continueCycle();}
		|	'return' e=expr {if (v != null) v.returnStatement($e.value);}
		|	expr
		;

block	:	INDENT (block | atom+) (DEDENT | EOF)
 		;
		
construction
		:	'if' e=expr ':' {if (v != null) v.startIf($e.value);} constr_atom 
					('elif' {if (v != null) v.startElse();} e=expr {if (v != null) v.startElif($e.value);} ':' constr_atom)* 
					('else' {if (v != null) v.startElse();} ':' constr_atom)?
					{if (v != null) v.stopIf();}
		|	'while' {if (v != null) v.startCycle();}
					e=expr ':' {if (v != null) v.startIf($e.value);} constr_atom 
					{
					if (v != null) {
						v.startElse();
						v.breakCycle();
						v.stopIf();
						v.stopCycle();
					}
					}
		|	'for' ID 'in' 'range' '(' e1=expr 
					{
					if (v != null) {
						v.assign($ID.text, $e1.value);
						v.assign("#INCR", v.getVariable(0));
					}
					}
					',' e2=expr ')'
					{
					if (v != null) {
						v.assign("#LIM", $e2.value);
						v.startCycle();
						int incr = v.getVariableByName("#INCR");
						int it = v.getVariableByName($ID.text);
						v.assign($ID.text, v.getVariable("+", it, incr));
						v.assign("#INCR", v.getVariable(1));
						v.startIf(v.getVariable("<", v.getVariableByName($ID.text), v.getVariableByName("#LIM")));
					}
					}
					':' constr_atom 
					{
					if (v != null) {
						v.startElse();
						v.breakCycle();
						v.stopIf();
						v.stopCycle();
					}
					}
		;

expr returns [int value]
		:	{$value = -1;} e=boolExpr {$value = $e.value;}
				(LOGIC e=boolExpr {$value = v == null ? -1 : v.getVariable($LOGIC.text, $value, $e.value);})*
		;
		
boolExpr returns [int value]
		:	NOT? e=compExpr {$value = ($NOT.text == null || v == null) ? $e.value : v.getVariable("not", $e.value, -1);}
		;
		
compExpr returns [int value]
		:   e=sumExpr {$value = $e.value;}
				(COMP e=sumExpr {$value = v == null ? -1 : v.getVariable($COMP.text, $value, $e.value);} )*
   		;		

sumExpr returns [int value]
		:   e=multExpr {$value = $e.value;}
				(SUM e=multExpr {$value = v == null ? -1 : v.getVariable($SUM.text, $value, $e.value);} )*
   		;

multExpr returns [int value]
		:   e=atomExpr {$value = $e.value;}
				(MULT e = atomExpr {$value = v == null ? -1 : v.getVariable($MULT.text, $value, $e.value);} )*
    	; 

atomExpr returns [int value]
		: 	INT {$value = v == null ? -1 : v.getVariable(new Integer($INT.text));} 
		| 	FLOAT {$value = v == null ? -1 : v.getVariable(new Double($FLOAT.text));}
		| 	STRING {$value = v == null ? -1 : v.getVariable(getStr($STRING.text));}
		| 	BOOL {$value = v == null ? -1 : v.getVariable(new Boolean($BOOL.text));}
		|	'None' {$value = v == null ? -1 : v.getVariable(null);}
    	|   ID {$value = v == null ? -1 : v.getVariableByName($ID.text);}
    	|	e=funCall {$value = v == null ? -1 : $e.value;}
        |   '(' e=expr {$value = v == null ? -1 : $e.value;} ')'
        |	SUM e=atomExpr {$value = v == null ? -1 : v.getVariable($SUM.text, $e.value, -1);}
    	;
    	
funCall	returns [int value]
		:	ID '(' {List<Integer> list = new ArrayList<Integer>();} 
				(e=expr{list.add($e.value);} (',' e=expr{list.add($e.value);})*)? ')'
				{value = v == null ? -1 : v.getVariableByFunctionCall($ID.text, list);} 
		;
		
decl	:	'def' name=ID '(' {List<String> list = new ArrayList<String>();} 
					(e=ID{list.add($e.text);} (',' e=ID{list.add($e.text);})*)? ')'
					{if (v != null) v.startFunctionDeclaration($name.text, list);}
			':' NL block {if (v != null) v.endFunctionDeclaration();}
		;	
   
/* Terminals */    

NEWLINE	:	 NL+ WS?
{
	
	emit(new CommonToken(NL, "NL"));
	int n = $WS.text == null ? 0 : $WS.text.length();
	if(n > previousIndents) {
		for (int i = 0; i < n - previousIndents; i++)
			jump(INDENT);
		previousIndents = n;
	} else if(n < previousIndents) {
		for (int i = 0; i < previousIndents - n; i++) {
			jump(DEDENT);
		}
		previousIndents = n;
	}
}
;

SPACE 	:	WS {skip();}
 		;

fragment
NL		:	'\r'? '\n' | '\r'
		;
		
fragment
WS		:	(' ' | '\t')+
		;
		
fragment
INDENT	:
		;
		
fragment
DEDENT	: 
		;
		
COMP	:	'==' | '!=' | '<' | '>' | '<=' | '>='	
		;
		
LOGIC	:	'or' | 'and'
		;
		
NOT		:	'not'
		;
		
SUM 	:	'+' | '-'
		;
		
MULT	:	'*' | '/' | '%'
		;

INT 	:	'0'..'9'+
    	;
    	
BOOL	:	'True'
   		|	'False'
   		;

ID		:	('_'|'a'..'z' | 'A'..'Z')('_'|'a'..'z' | 'A'..'Z' | '0'..'9')*
 		;

FLOAT   :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    	|   '.' ('0'..'9')+ EXPONENT?
    	|   ('0'..'9')+ EXPONENT
    	;
   
   
STRING	:  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    	|  '\'' ( ESC_SEQ | ~('\\'|'\'') )* '\''
    	;

fragment
EXPONENT: ('e'|'E') ('+'|'-')? ('0'..'9')+
		;

fragment
HEX_DIGIT
		: ('0'..'9'|'a'..'f'|'A'..'F')
		;

fragment
ESC_SEQ	:   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    	|   UNICODE_ESC
    	|   OCTAL_ESC
    	;

fragment
OCTAL_ESC
    	:   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    	|   '\\' ('0'..'7') ('0'..'7')
    	|   '\\' ('0'..'7')
    	;

fragment
UNICODE_ESC
    	:   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    	;
    
COMMENT	:   '#' ~('\n'|'\r')* {skip();}
    	|   '"""' ( options {greedy=false;} : . )* '"""' {skip();}
    	;