// $ANTLR 3.4 C:\\ANTLR\\Python\\Python.g 2014-04-16 21:49:51

package ru.ifmo.ctddev.drozdov.python.parsing;

import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PythonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "COMMENT", "COMP", "DEDENT", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INDENT", "INT", "LOGIC", "MULT", "NEWLINE", "NL", "NOT", "OCTAL_ESC", "SPACE", "STRING", "SUM", "UNICODE_ESC", "WS", "'('", "')'", "','", "':'", "'='", "'None'", "'['", "']'", "'break'", "'continue'", "'def'", "'elif'", "'else'", "'for'", "'if'", "'in'", "'pass'", "'print'", "'range'", "'return'", "'while'"
    };

    public static final int EOF=-1;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int BOOL=4;
    public static final int COMMENT=5;
    public static final int COMP=6;
    public static final int DEDENT=7;
    public static final int ESC_SEQ=8;
    public static final int EXPONENT=9;
    public static final int FLOAT=10;
    public static final int HEX_DIGIT=11;
    public static final int ID=12;
    public static final int INDENT=13;
    public static final int INT=14;
    public static final int LOGIC=15;
    public static final int MULT=16;
    public static final int NEWLINE=17;
    public static final int NL=18;
    public static final int NOT=19;
    public static final int OCTAL_ESC=20;
    public static final int SPACE=21;
    public static final int STRING=22;
    public static final int SUM=23;
    public static final int UNICODE_ESC=24;
    public static final int WS=25;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PythonParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PythonParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return PythonParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\ANTLR\\Python\\Python.g"; }



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
    	return str.substring(1, str.length() - 1).replaceAll("\\\\(\\\\)", "$1");
    }

    public class Position {
    	public int line, pos;
    	
    	private Position(Token token) {
    		line = token.getLine();
    		pos = token.getCharPositionInLine();
    	}
    }

    private Position curPos;

    public Position getCurrentPosition() {
    	return curPos;
    }

    private void move(Token token) {
    	curPos = new Position(token);
    }
    	



    // $ANTLR start "parse"
    // C:\\ANTLR\\Python\\Python.g:261:1: parse : ( NL )* ( atom | decl )+ EOF ;
    public final void parse() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:261:7: ( ( NL )* ( atom | decl )+ EOF )
            // C:\\ANTLR\\Python\\Python.g:261:10: ( NL )* ( atom | decl )+ EOF
            {
            // C:\\ANTLR\\Python\\Python.g:261:10: ( NL )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:261:10: NL
            	    {
            	    match(input,NL,FOLLOW_NL_in_parse50); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // C:\\ANTLR\\Python\\Python.g:261:14: ( atom | decl )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==BOOL||LA2_0==FLOAT||LA2_0==ID||LA2_0==INT||LA2_0==NOT||(LA2_0 >= STRING && LA2_0 <= SUM)||LA2_0==26||LA2_0==31||(LA2_0 >= 34 && LA2_0 <= 35)||(LA2_0 >= 39 && LA2_0 <= 40)||(LA2_0 >= 42 && LA2_0 <= 43)||(LA2_0 >= 45 && LA2_0 <= 46)) ) {
                    alt2=1;
                }
                else if ( (LA2_0==36) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:261:15: atom
            	    {
            	    pushFollow(FOLLOW_atom_in_parse54);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\ANTLR\\Python\\Python.g:261:22: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_parse58);
            	    decl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            match(input,EOF,FOLLOW_EOF_in_parse62); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "parse"



    // $ANTLR start "atom"
    // C:\\ANTLR\\Python\\Python.g:264:1: atom : ( simple_atom | construction );
    public final void atom() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:264:6: ( simple_atom | construction )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==BOOL||LA3_0==FLOAT||LA3_0==ID||LA3_0==INT||LA3_0==NOT||(LA3_0 >= STRING && LA3_0 <= SUM)||LA3_0==26||LA3_0==31||(LA3_0 >= 34 && LA3_0 <= 35)||(LA3_0 >= 42 && LA3_0 <= 43)||LA3_0==45) ) {
                alt3=1;
            }
            else if ( ((LA3_0 >= 39 && LA3_0 <= 40)||LA3_0==46) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:264:8: simple_atom
                    {
                    pushFollow(FOLLOW_simple_atom_in_atom75);
                    simple_atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:264:22: construction
                    {
                    pushFollow(FOLLOW_construction_in_atom79);
                    construction();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atom"



    // $ANTLR start "constr_atom"
    // C:\\ANTLR\\Python\\Python.g:267:1: constr_atom : ( simple_atom | NL block );
    public final void constr_atom() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:268:3: ( simple_atom | NL block )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==BOOL||LA4_0==FLOAT||LA4_0==ID||LA4_0==INT||LA4_0==NOT||(LA4_0 >= STRING && LA4_0 <= SUM)||LA4_0==26||LA4_0==31||(LA4_0 >= 34 && LA4_0 <= 35)||(LA4_0 >= 42 && LA4_0 <= 43)||LA4_0==45) ) {
                alt4=1;
            }
            else if ( (LA4_0==NL) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:268:5: simple_atom
                    {
                    pushFollow(FOLLOW_simple_atom_in_constr_atom94);
                    simple_atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:268:19: NL block
                    {
                    match(input,NL,FOLLOW_NL_in_constr_atom98); 

                    pushFollow(FOLLOW_block_in_constr_atom100);
                    block();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "constr_atom"



    // $ANTLR start "simple_atom"
    // C:\\ANTLR\\Python\\Python.g:271:1: simple_atom : simple ( NL | EOF ) ;
    public final void simple_atom() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:272:3: ( simple ( NL | EOF ) )
            // C:\\ANTLR\\Python\\Python.g:272:5: simple ( NL | EOF )
            {
            pushFollow(FOLLOW_simple_in_simple_atom116);
            simple();

            state._fsp--;


            if ( input.LA(1)==EOF||input.LA(1)==NL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "simple_atom"



    // $ANTLR start "simple"
    // C:\\ANTLR\\Python\\Python.g:275:1: simple : ( 'pass' |e0= 'print' e= expr | ID '=' e= expr |e0= 'break' |e0= 'continue' |e0= 'return' e= expr | expr );
    public final void simple() throws RecognitionException {
        Token e0=null;
        Token ID1=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:275:8: ( 'pass' |e0= 'print' e= expr | ID '=' e= expr |e0= 'break' |e0= 'continue' |e0= 'return' e= expr | expr )
            int alt5=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt5=1;
                }
                break;
            case 43:
                {
                alt5=2;
                }
                break;
            case ID:
                {
                int LA5_3 = input.LA(2);

                if ( (LA5_3==30) ) {
                    alt5=3;
                }
                else if ( (LA5_3==EOF||LA5_3==COMP||(LA5_3 >= LOGIC && LA5_3 <= MULT)||LA5_3==NL||LA5_3==SUM||LA5_3==26||LA5_3==32) ) {
                    alt5=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 3, input);

                    throw nvae;

                }
                }
                break;
            case 34:
                {
                alt5=4;
                }
                break;
            case 35:
                {
                alt5=5;
                }
                break;
            case 45:
                {
                alt5=6;
                }
                break;
            case BOOL:
            case FLOAT:
            case INT:
            case NOT:
            case STRING:
            case SUM:
            case 26:
            case 31:
                {
                alt5=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:275:10: 'pass'
                    {
                    match(input,42,FOLLOW_42_in_simple136); 

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:276:5: e0= 'print' e= expr
                    {
                    e0=(Token)match(input,43,FOLLOW_43_in_simple144); 

                    pushFollow(FOLLOW_expr_in_simple148);
                    e=expr();

                    state._fsp--;


                    move(e0); if (v != null) v.print(e);

                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:277:5: ID '=' e= expr
                    {
                    ID1=(Token)match(input,ID,FOLLOW_ID_in_simple156); 

                    match(input,30,FOLLOW_30_in_simple158); 

                    pushFollow(FOLLOW_expr_in_simple162);
                    e=expr();

                    state._fsp--;


                    move(ID1); if (v != null) v.assign((ID1!=null?ID1.getText():null), e);

                    }
                    break;
                case 4 :
                    // C:\\ANTLR\\Python\\Python.g:278:5: e0= 'break'
                    {
                    e0=(Token)match(input,34,FOLLOW_34_in_simple172); 

                    move(e0); if (v != null) v.breakCycle();

                    }
                    break;
                case 5 :
                    // C:\\ANTLR\\Python\\Python.g:279:5: e0= 'continue'
                    {
                    e0=(Token)match(input,35,FOLLOW_35_in_simple182); 

                    move(e0); if (v != null) v.continueCycle();

                    }
                    break;
                case 6 :
                    // C:\\ANTLR\\Python\\Python.g:280:5: e0= 'return' e= expr
                    {
                    e0=(Token)match(input,45,FOLLOW_45_in_simple192); 

                    pushFollow(FOLLOW_expr_in_simple196);
                    e=expr();

                    state._fsp--;


                    move(e0); if (v != null) v.returnStatement(e);

                    }
                    break;
                case 7 :
                    // C:\\ANTLR\\Python\\Python.g:281:5: expr
                    {
                    pushFollow(FOLLOW_expr_in_simple204);
                    expr();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "simple"



    // $ANTLR start "block"
    // C:\\ANTLR\\Python\\Python.g:284:1: block : INDENT ( block | ( atom )+ ) ( DEDENT | EOF ) ;
    public final void block() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:284:7: ( INDENT ( block | ( atom )+ ) ( DEDENT | EOF ) )
            // C:\\ANTLR\\Python\\Python.g:284:9: INDENT ( block | ( atom )+ ) ( DEDENT | EOF )
            {
            match(input,INDENT,FOLLOW_INDENT_in_block215); 

            // C:\\ANTLR\\Python\\Python.g:284:16: ( block | ( atom )+ )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INDENT) ) {
                alt7=1;
            }
            else if ( (LA7_0==BOOL||LA7_0==FLOAT||LA7_0==ID||LA7_0==INT||LA7_0==NOT||(LA7_0 >= STRING && LA7_0 <= SUM)||LA7_0==26||LA7_0==31||(LA7_0 >= 34 && LA7_0 <= 35)||(LA7_0 >= 39 && LA7_0 <= 40)||(LA7_0 >= 42 && LA7_0 <= 43)||(LA7_0 >= 45 && LA7_0 <= 46)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:284:17: block
                    {
                    pushFollow(FOLLOW_block_in_block218);
                    block();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:284:25: ( atom )+
                    {
                    // C:\\ANTLR\\Python\\Python.g:284:25: ( atom )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==BOOL||LA6_0==FLOAT||LA6_0==ID||LA6_0==INT||LA6_0==NOT||(LA6_0 >= STRING && LA6_0 <= SUM)||LA6_0==26||LA6_0==31||(LA6_0 >= 34 && LA6_0 <= 35)||(LA6_0 >= 39 && LA6_0 <= 40)||(LA6_0 >= 42 && LA6_0 <= 43)||(LA6_0 >= 45 && LA6_0 <= 46)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:284:25: atom
                    	    {
                    	    pushFollow(FOLLOW_atom_in_block222);
                    	    atom();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;

            }


            if ( input.LA(1)==EOF||input.LA(1)==DEDENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "construction"
    // C:\\ANTLR\\Python\\Python.g:287:1: construction : (e0= 'if' e= expr ':' constr_atom (e0= 'elif' e= expr ':' constr_atom )* (e0= 'else' ':' constr_atom )? |e0= 'while' e= expr ':' constr_atom |e0= 'for' ID 'in' 'range' '(' e1= expr ',' e2= expr ')' ':' constr_atom );
    public final void construction() throws RecognitionException {
        Token e0=null;
        Token ID2=null;
        int e =0;

        int e1 =0;

        int e2 =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:288:3: (e0= 'if' e= expr ':' constr_atom (e0= 'elif' e= expr ':' constr_atom )* (e0= 'else' ':' constr_atom )? |e0= 'while' e= expr ':' constr_atom |e0= 'for' ID 'in' 'range' '(' e1= expr ',' e2= expr ')' ':' constr_atom )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt10=1;
                }
                break;
            case 46:
                {
                alt10=2;
                }
                break;
            case 39:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:288:5: e0= 'if' e= expr ':' constr_atom (e0= 'elif' e= expr ':' constr_atom )* (e0= 'else' ':' constr_atom )?
                    {
                    e0=(Token)match(input,40,FOLLOW_40_in_construction250); 

                    pushFollow(FOLLOW_expr_in_construction254);
                    e=expr();

                    state._fsp--;


                    match(input,29,FOLLOW_29_in_construction256); 

                    move(e0); if (v != null) v.startIf(e);

                    pushFollow(FOLLOW_constr_atom_in_construction260);
                    constr_atom();

                    state._fsp--;


                    // C:\\ANTLR\\Python\\Python.g:289:6: (e0= 'elif' e= expr ':' constr_atom )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==37) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:289:7: e0= 'elif' e= expr ':' constr_atom
                    	    {
                    	    e0=(Token)match(input,37,FOLLOW_37_in_construction271); 

                    	    move(e0); if (v != null) v.startElse();

                    	    pushFollow(FOLLOW_expr_in_construction277);
                    	    e=expr();

                    	    state._fsp--;


                    	    if (v != null) v.startElif(e);

                    	    match(input,29,FOLLOW_29_in_construction281); 

                    	    pushFollow(FOLLOW_constr_atom_in_construction283);
                    	    constr_atom();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    // C:\\ANTLR\\Python\\Python.g:290:6: (e0= 'else' ':' constr_atom )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==38) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:290:7: e0= 'else' ':' constr_atom
                            {
                            e0=(Token)match(input,38,FOLLOW_38_in_construction296); 

                            move(e0); if (v != null) v.startElse();

                            match(input,29,FOLLOW_29_in_construction300); 

                            pushFollow(FOLLOW_constr_atom_in_construction302);
                            constr_atom();

                            state._fsp--;


                            }
                            break;

                    }


                    if (v != null) v.stopIf();

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:292:5: e0= 'while' e= expr ':' constr_atom
                    {
                    e0=(Token)match(input,46,FOLLOW_46_in_construction319); 

                    move(e0); if (v != null) v.startCycle();

                    pushFollow(FOLLOW_expr_in_construction330);
                    e=expr();

                    state._fsp--;


                    match(input,29,FOLLOW_29_in_construction332); 

                    if (v != null) v.startIf(e);

                    pushFollow(FOLLOW_constr_atom_in_construction336);
                    constr_atom();

                    state._fsp--;



                    					if (v != null) {
                    						v.startElse();
                    						v.breakCycle();
                    						v.stopIf();
                    						v.stopCycle();
                    					}
                    					

                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:302:5: e0= 'for' ID 'in' 'range' '(' e1= expr ',' e2= expr ')' ':' constr_atom
                    {
                    e0=(Token)match(input,39,FOLLOW_39_in_construction352); 

                    ID2=(Token)match(input,ID,FOLLOW_ID_in_construction354); 

                    match(input,41,FOLLOW_41_in_construction356); 

                    match(input,44,FOLLOW_44_in_construction358); 

                    match(input,26,FOLLOW_26_in_construction360); 

                    pushFollow(FOLLOW_expr_in_construction364);
                    e1=expr();

                    state._fsp--;



                    					move(e0); 
                    					if (v != null) {
                    						v.assign((ID2!=null?ID2.getText():null), e1);
                    						v.assign("#INCR", v.getVariable(0));
                    					}
                    					

                    match(input,28,FOLLOW_28_in_construction379); 

                    pushFollow(FOLLOW_expr_in_construction383);
                    e2=expr();

                    state._fsp--;


                    match(input,27,FOLLOW_27_in_construction385); 


                    					if (v != null) {
                    						v.assign("#LIM", e2);
                    						v.startCycle();
                    						int incr = v.getVariableByName("#INCR");
                    						int it = v.getVariableByName((ID2!=null?ID2.getText():null));
                    						v.assign((ID2!=null?ID2.getText():null), v.getVariable("+", it, incr));
                    						v.assign("#INCR", v.getVariable(1));
                    						v.startIf(v.getVariable("<", v.getVariableByName((ID2!=null?ID2.getText():null)), v.getVariableByName("#LIM")));
                    					}
                    					

                    match(input,29,FOLLOW_29_in_construction399); 

                    pushFollow(FOLLOW_constr_atom_in_construction401);
                    constr_atom();

                    state._fsp--;



                    					if (v != null) {
                    						v.startElse();
                    						v.breakCycle();
                    						v.stopIf();
                    						v.stopCycle();
                    					}
                    					

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "construction"



    // $ANTLR start "expr"
    // C:\\ANTLR\\Python\\Python.g:333:1: expr returns [int value] :e= boolExpr ( LOGIC e= boolExpr )* ;
    public final int expr() throws RecognitionException {
        int value = 0;


        Token LOGIC3=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:334:3: (e= boolExpr ( LOGIC e= boolExpr )* )
            // C:\\ANTLR\\Python\\Python.g:334:5: e= boolExpr ( LOGIC e= boolExpr )*
            {
            value = -1;

            pushFollow(FOLLOW_boolExpr_in_expr430);
            e=boolExpr();

            state._fsp--;


            value = e;

            // C:\\ANTLR\\Python\\Python.g:335:5: ( LOGIC e= boolExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LOGIC) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:335:6: LOGIC e= boolExpr
            	    {
            	    LOGIC3=(Token)match(input,LOGIC,FOLLOW_LOGIC_in_expr439); 

            	    pushFollow(FOLLOW_boolExpr_in_expr443);
            	    e=boolExpr();

            	    state._fsp--;


            	    value = v == null ? -1 : v.getVariable((LOGIC3!=null?LOGIC3.getText():null), value, e);

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "expr"



    // $ANTLR start "boolExpr"
    // C:\\ANTLR\\Python\\Python.g:338:1: boolExpr returns [int value] : ( NOT )? e= compExpr ;
    public final int boolExpr() throws RecognitionException {
        int value = 0;


        Token NOT4=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:339:3: ( ( NOT )? e= compExpr )
            // C:\\ANTLR\\Python\\Python.g:339:5: ( NOT )? e= compExpr
            {
            // C:\\ANTLR\\Python\\Python.g:339:5: ( NOT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NOT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:339:5: NOT
                    {
                    NOT4=(Token)match(input,NOT,FOLLOW_NOT_in_boolExpr466); 

                    }
                    break;

            }


            pushFollow(FOLLOW_compExpr_in_boolExpr471);
            e=compExpr();

            state._fsp--;


            value = ((NOT4!=null?NOT4.getText():null) == null || v == null) ? e : v.getVariable("not", e, -1);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "boolExpr"



    // $ANTLR start "compExpr"
    // C:\\ANTLR\\Python\\Python.g:342:1: compExpr returns [int value] : e= sumExpr ( COMP e= sumExpr )* ;
    public final int compExpr() throws RecognitionException {
        int value = 0;


        Token COMP5=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:343:3: (e= sumExpr ( COMP e= sumExpr )* )
            // C:\\ANTLR\\Python\\Python.g:343:7: e= sumExpr ( COMP e= sumExpr )*
            {
            pushFollow(FOLLOW_sumExpr_in_compExpr496);
            e=sumExpr();

            state._fsp--;


            value = e;

            // C:\\ANTLR\\Python\\Python.g:344:5: ( COMP e= sumExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMP) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:344:6: COMP e= sumExpr
            	    {
            	    COMP5=(Token)match(input,COMP,FOLLOW_COMP_in_compExpr505); 

            	    pushFollow(FOLLOW_sumExpr_in_compExpr509);
            	    e=sumExpr();

            	    state._fsp--;


            	    value = v == null ? -1 : v.getVariable((COMP5!=null?COMP5.getText():null), value, e);

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "compExpr"



    // $ANTLR start "sumExpr"
    // C:\\ANTLR\\Python\\Python.g:347:1: sumExpr returns [int value] : e= multExpr ( SUM e= multExpr )* ;
    public final int sumExpr() throws RecognitionException {
        int value = 0;


        Token SUM6=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:348:3: (e= multExpr ( SUM e= multExpr )* )
            // C:\\ANTLR\\Python\\Python.g:348:7: e= multExpr ( SUM e= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_sumExpr540);
            e=multExpr();

            state._fsp--;


            value = e;

            // C:\\ANTLR\\Python\\Python.g:349:5: ( SUM e= multExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==SUM) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:349:6: SUM e= multExpr
            	    {
            	    SUM6=(Token)match(input,SUM,FOLLOW_SUM_in_sumExpr549); 

            	    pushFollow(FOLLOW_multExpr_in_sumExpr553);
            	    e=multExpr();

            	    state._fsp--;


            	    value = v == null ? -1 : v.getVariable((SUM6!=null?SUM6.getText():null), value, e);

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "sumExpr"



    // $ANTLR start "multExpr"
    // C:\\ANTLR\\Python\\Python.g:352:1: multExpr returns [int value] : e= atomExpr ( MULT e= atomExpr )* ;
    public final int multExpr() throws RecognitionException {
        int value = 0;


        Token MULT7=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:353:3: (e= atomExpr ( MULT e= atomExpr )* )
            // C:\\ANTLR\\Python\\Python.g:353:7: e= atomExpr ( MULT e= atomExpr )*
            {
            pushFollow(FOLLOW_atomExpr_in_multExpr582);
            e=atomExpr();

            state._fsp--;


            value = e;

            // C:\\ANTLR\\Python\\Python.g:354:5: ( MULT e= atomExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==MULT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:354:6: MULT e= atomExpr
            	    {
            	    MULT7=(Token)match(input,MULT,FOLLOW_MULT_in_multExpr591); 

            	    pushFollow(FOLLOW_atomExpr_in_multExpr597);
            	    e=atomExpr();

            	    state._fsp--;


            	    value = v == null ? -1 : v.getVariable((MULT7!=null?MULT7.getText():null), value, e);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "multExpr"



    // $ANTLR start "atomExpr"
    // C:\\ANTLR\\Python\\Python.g:357:1: atomExpr returns [int value] : ( INT | FLOAT | STRING | BOOL | 'None' | ID |e= funCall | '(' e= expr ')' | SUM e= atomExpr | ID '[' (e1= expr )? ':' (e2= expr )? ( ':' (e3= expr )? )? ']' );
    public final int atomExpr() throws RecognitionException {
        int value = 0;


        Token INT8=null;
        Token FLOAT9=null;
        Token STRING10=null;
        Token BOOL11=null;
        Token ID12=null;
        Token SUM13=null;
        Token ID14=null;
        int e =0;

        int e1 =0;

        int e2 =0;

        int e3 =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:358:3: ( INT | FLOAT | STRING | BOOL | 'None' | ID |e= funCall | '(' e= expr ')' | SUM e= atomExpr | ID '[' (e1= expr )? ':' (e2= expr )? ( ':' (e3= expr )? )? ']' )
            int alt20=10;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt20=1;
                }
                break;
            case FLOAT:
                {
                alt20=2;
                }
                break;
            case STRING:
                {
                alt20=3;
                }
                break;
            case BOOL:
                {
                alt20=4;
                }
                break;
            case 31:
                {
                alt20=5;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    alt20=7;
                    }
                    break;
                case EOF:
                case COMP:
                case LOGIC:
                case MULT:
                case NL:
                case SUM:
                case 27:
                case 28:
                case 29:
                case 33:
                    {
                    alt20=6;
                    }
                    break;
                case 32:
                    {
                    alt20=10;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 6, input);

                    throw nvae;

                }

                }
                break;
            case 26:
                {
                alt20=8;
                }
                break;
            case SUM:
                {
                alt20=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:358:6: INT
                    {
                    INT8=(Token)match(input,INT,FOLLOW_INT_in_atomExpr624); 

                    value = v == null ? -1 : v.getVariable(new Integer((INT8!=null?INT8.getText():null)));

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:359:6: FLOAT
                    {
                    FLOAT9=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atomExpr634); 

                    value = v == null ? -1 : v.getVariable(new Double((FLOAT9!=null?FLOAT9.getText():null)));

                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:360:6: STRING
                    {
                    STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_atomExpr643); 

                    value = v == null ? -1 : v.getVariable(getStr((STRING10!=null?STRING10.getText():null)));

                    }
                    break;
                case 4 :
                    // C:\\ANTLR\\Python\\Python.g:361:6: BOOL
                    {
                    BOOL11=(Token)match(input,BOOL,FOLLOW_BOOL_in_atomExpr652); 

                    value = v == null ? -1 : v.getVariable(new Boolean((BOOL11!=null?BOOL11.getText():null)));

                    }
                    break;
                case 5 :
                    // C:\\ANTLR\\Python\\Python.g:362:5: 'None'
                    {
                    match(input,31,FOLLOW_31_in_atomExpr660); 

                    value = v == null ? -1 : v.getVariable(null);

                    }
                    break;
                case 6 :
                    // C:\\ANTLR\\Python\\Python.g:363:10: ID
                    {
                    ID12=(Token)match(input,ID,FOLLOW_ID_in_atomExpr673); 

                    value = v == null ? -1 : v.getVariableByName((ID12!=null?ID12.getText():null));

                    }
                    break;
                case 7 :
                    // C:\\ANTLR\\Python\\Python.g:364:8: e= funCall
                    {
                    pushFollow(FOLLOW_funCall_in_atomExpr686);
                    e=funCall();

                    state._fsp--;


                    value = v == null ? -1 : e;

                    }
                    break;
                case 8 :
                    // C:\\ANTLR\\Python\\Python.g:365:13: '(' e= expr ')'
                    {
                    match(input,26,FOLLOW_26_in_atomExpr702); 

                    pushFollow(FOLLOW_expr_in_atomExpr706);
                    e=expr();

                    state._fsp--;


                    value = v == null ? -1 : e;

                    match(input,27,FOLLOW_27_in_atomExpr710); 

                    }
                    break;
                case 9 :
                    // C:\\ANTLR\\Python\\Python.g:366:11: SUM e= atomExpr
                    {
                    SUM13=(Token)match(input,SUM,FOLLOW_SUM_in_atomExpr722); 

                    pushFollow(FOLLOW_atomExpr_in_atomExpr726);
                    e=atomExpr();

                    state._fsp--;


                    value = v == null ? -1 : v.getVariable((SUM13!=null?SUM13.getText():null), e, -1);

                    }
                    break;
                case 10 :
                    // C:\\ANTLR\\Python\\Python.g:367:11: ID '[' (e1= expr )? ':' (e2= expr )? ( ':' (e3= expr )? )? ']'
                    {
                    ID14=(Token)match(input,ID,FOLLOW_ID_in_atomExpr740); 

                    value = v == null ? -1 : v.getVariableByName((ID14!=null?ID14.getText():null));

                    match(input,32,FOLLOW_32_in_atomExpr753); 

                    e1=-1;

                    // C:\\ANTLR\\Python\\Python.g:368:23: (e1= expr )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==BOOL||LA16_0==FLOAT||LA16_0==ID||LA16_0==INT||LA16_0==NOT||(LA16_0 >= STRING && LA16_0 <= SUM)||LA16_0==26||LA16_0==31) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:368:24: e1= expr
                            {
                            pushFollow(FOLLOW_expr_in_atomExpr760);
                            e1=expr();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input,29,FOLLOW_29_in_atomExpr764); 

                    // C:\\ANTLR\\Python\\Python.g:368:38: (e2= expr )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==BOOL||LA17_0==FLOAT||LA17_0==ID||LA17_0==INT||LA17_0==NOT||(LA17_0 >= STRING && LA17_0 <= SUM)||LA17_0==26||LA17_0==31) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:368:39: e2= expr
                            {
                            pushFollow(FOLLOW_expr_in_atomExpr769);
                            e2=expr();

                            state._fsp--;


                            value = v == null ? -1 : v.getVariable("]", value, e2);

                            }
                            break;

                    }


                    if (e1 >= 0) value = v == null ? -1 : v.getVariable("[", value, e1);

                    // C:\\ANTLR\\Python\\Python.g:371:10: ( ':' (e3= expr )? )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==29) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:371:11: ':' (e3= expr )?
                            {
                            match(input,29,FOLLOW_29_in_atomExpr808); 

                            // C:\\ANTLR\\Python\\Python.g:371:15: (e3= expr )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==BOOL||LA18_0==FLOAT||LA18_0==ID||LA18_0==INT||LA18_0==NOT||(LA18_0 >= STRING && LA18_0 <= SUM)||LA18_0==26||LA18_0==31) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // C:\\ANTLR\\Python\\Python.g:371:16: e3= expr
                                    {
                                    pushFollow(FOLLOW_expr_in_atomExpr813);
                                    e3=expr();

                                    state._fsp--;


                                    value = v == null ? -1 : v.getVariable(":", value, e3);

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    match(input,33,FOLLOW_33_in_atomExpr841); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "atomExpr"



    // $ANTLR start "funCall"
    // C:\\ANTLR\\Python\\Python.g:376:1: funCall returns [int value] : e0= ID '(' (e= expr ( ',' e= expr )* )? ')' ;
    public final int funCall() throws RecognitionException {
        int value = 0;


        Token e0=null;
        int e =0;


        try {
            // C:\\ANTLR\\Python\\Python.g:377:3: (e0= ID '(' (e= expr ( ',' e= expr )* )? ')' )
            // C:\\ANTLR\\Python\\Python.g:377:5: e0= ID '(' (e= expr ( ',' e= expr )* )? ')'
            {
            e0=(Token)match(input,ID,FOLLOW_ID_in_funCall868); 

            match(input,26,FOLLOW_26_in_funCall870); 

            move(e0); List<Integer> list = new ArrayList<Integer>();

            // C:\\ANTLR\\Python\\Python.g:378:5: (e= expr ( ',' e= expr )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==BOOL||LA22_0==FLOAT||LA22_0==ID||LA22_0==INT||LA22_0==NOT||(LA22_0 >= STRING && LA22_0 <= SUM)||LA22_0==26||LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:378:6: e= expr ( ',' e= expr )*
                    {
                    pushFollow(FOLLOW_expr_in_funCall882);
                    e=expr();

                    state._fsp--;


                    list.add(e);

                    // C:\\ANTLR\\Python\\Python.g:378:34: ( ',' e= expr )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==28) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:378:35: ',' e= expr
                    	    {
                    	    match(input,28,FOLLOW_28_in_funCall886); 

                    	    pushFollow(FOLLOW_expr_in_funCall890);
                    	    e=expr();

                    	    state._fsp--;


                    	    list.add(e);

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_funCall897); 

            value = v == null ? -1 : v.getVariableByFunctionCall((e0!=null?e0.getText():null), list);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "funCall"



    // $ANTLR start "decl"
    // C:\\ANTLR\\Python\\Python.g:382:1: decl : e0= 'def' name= ID '(' (e= ID ( ',' e= ID )* )? ')' ':' NL block ;
    public final void decl() throws RecognitionException {
        Token e0=null;
        Token name=null;
        Token e=null;

        try {
            // C:\\ANTLR\\Python\\Python.g:382:6: (e0= 'def' name= ID '(' (e= ID ( ',' e= ID )* )? ')' ':' NL block )
            // C:\\ANTLR\\Python\\Python.g:382:8: e0= 'def' name= ID '(' (e= ID ( ',' e= ID )* )? ')' ':' NL block
            {
            e0=(Token)match(input,36,FOLLOW_36_in_decl919); 

            name=(Token)match(input,ID,FOLLOW_ID_in_decl923); 

            match(input,26,FOLLOW_26_in_decl925); 

            move(e0);List<String> list = new ArrayList<String>();

            // C:\\ANTLR\\Python\\Python.g:383:6: (e= ID ( ',' e= ID )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:383:7: e= ID ( ',' e= ID )*
                    {
                    e=(Token)match(input,ID,FOLLOW_ID_in_decl938); 

                    list.add((e!=null?e.getText():null));

                    // C:\\ANTLR\\Python\\Python.g:383:32: ( ',' e= ID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==28) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:383:33: ',' e= ID
                    	    {
                    	    match(input,28,FOLLOW_28_in_decl942); 

                    	    e=(Token)match(input,ID,FOLLOW_ID_in_decl946); 

                    	    list.add((e!=null?e.getText():null));

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,27,FOLLOW_27_in_decl953); 

            if (v != null) v.startFunctionDeclaration((name!=null?name.getText():null), list);

            match(input,29,FOLLOW_29_in_decl965); 

            match(input,NL,FOLLOW_NL_in_decl967); 

            pushFollow(FOLLOW_block_in_decl969);
            block();

            state._fsp--;


            if (v != null) v.endFunctionDeclaration();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "decl"

    // Delegated rules


 

    public static final BitSet FOLLOW_NL_in_parse50 = new BitSet(new long[]{0x00006D9C84CC5410L});
    public static final BitSet FOLLOW_atom_in_parse54 = new BitSet(new long[]{0x00006D9C84C85410L});
    public static final BitSet FOLLOW_decl_in_parse58 = new BitSet(new long[]{0x00006D9C84C85410L});
    public static final BitSet FOLLOW_EOF_in_parse62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_atom_in_atom75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_construction_in_atom79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_atom_in_constr_atom94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NL_in_constr_atom98 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_block_in_constr_atom100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_in_simple_atom116 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_set_in_simple_atom118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_simple136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_simple144 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_simple148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_simple156 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_simple158 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_simple162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_simple172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_simple182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_simple192 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_simple196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_simple204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_block215 = new BitSet(new long[]{0x00006D8C84C87410L});
    public static final BitSet FOLLOW_block_in_block218 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_atom_in_block222 = new BitSet(new long[]{0x00006D8C84C85490L});
    public static final BitSet FOLLOW_set_in_block226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_construction250 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_construction254 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_construction256 = new BitSet(new long[]{0x00002C0C84CC5410L});
    public static final BitSet FOLLOW_constr_atom_in_construction260 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_37_in_construction271 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_construction277 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_construction281 = new BitSet(new long[]{0x00002C0C84CC5410L});
    public static final BitSet FOLLOW_constr_atom_in_construction283 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_38_in_construction296 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_construction300 = new BitSet(new long[]{0x00002C0C84CC5410L});
    public static final BitSet FOLLOW_constr_atom_in_construction302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_construction319 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_construction330 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_construction332 = new BitSet(new long[]{0x00002C0C84CC5410L});
    public static final BitSet FOLLOW_constr_atom_in_construction336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_construction352 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_construction354 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_construction356 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_construction358 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_construction360 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_construction364 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_construction379 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_construction383 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_construction385 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_construction399 = new BitSet(new long[]{0x00002C0C84CC5410L});
    public static final BitSet FOLLOW_constr_atom_in_construction401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolExpr_in_expr430 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LOGIC_in_expr439 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_boolExpr_in_expr443 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_NOT_in_boolExpr466 = new BitSet(new long[]{0x0000000084C05410L});
    public static final BitSet FOLLOW_compExpr_in_boolExpr471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sumExpr_in_compExpr496 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMP_in_compExpr505 = new BitSet(new long[]{0x0000000084C05410L});
    public static final BitSet FOLLOW_sumExpr_in_compExpr509 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_multExpr_in_sumExpr540 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SUM_in_sumExpr549 = new BitSet(new long[]{0x0000000084C05410L});
    public static final BitSet FOLLOW_multExpr_in_sumExpr553 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_atomExpr_in_multExpr582 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_MULT_in_multExpr591 = new BitSet(new long[]{0x0000000084C05410L});
    public static final BitSet FOLLOW_atomExpr_in_multExpr597 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_INT_in_atomExpr624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atomExpr634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atomExpr643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_atomExpr652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_atomExpr660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atomExpr673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funCall_in_atomExpr686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_atomExpr702 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_atomExpr706 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_atomExpr710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_in_atomExpr722 = new BitSet(new long[]{0x0000000084C05410L});
    public static final BitSet FOLLOW_atomExpr_in_atomExpr726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atomExpr740 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_atomExpr753 = new BitSet(new long[]{0x00000000A4C85410L});
    public static final BitSet FOLLOW_expr_in_atomExpr760 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_atomExpr764 = new BitSet(new long[]{0x00000002A4C85410L});
    public static final BitSet FOLLOW_expr_in_atomExpr769 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_29_in_atomExpr808 = new BitSet(new long[]{0x0000000284C85410L});
    public static final BitSet FOLLOW_expr_in_atomExpr813 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_atomExpr841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_funCall868 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_funCall870 = new BitSet(new long[]{0x000000008CC85410L});
    public static final BitSet FOLLOW_expr_in_funCall882 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_funCall886 = new BitSet(new long[]{0x0000000084C85410L});
    public static final BitSet FOLLOW_expr_in_funCall890 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_funCall897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_decl919 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_decl923 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_decl925 = new BitSet(new long[]{0x0000000008001000L});
    public static final BitSet FOLLOW_ID_in_decl938 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_decl942 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_decl946 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_decl953 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_decl965 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_NL_in_decl967 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_block_in_decl969 = new BitSet(new long[]{0x0000000000000002L});

}