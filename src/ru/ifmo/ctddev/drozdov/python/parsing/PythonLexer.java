// $ANTLR 3.4 C:\\ANTLR\\Python\\Python.g 2014-04-16 21:49:51

package ru.ifmo.ctddev.drozdov.python.parsing;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PythonLexer extends Lexer {
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

    	
    private int previousIndents = 0;
    private int indentLevel = 0;
    java.util.Queue<Token> tokens = new java.util.LinkedList<Token>();

    private Token lastAdded;

    @Override
    public void emit(Token t) {
    	state.token = t;
    	tokens.offer(t);
    	lastAdded = t;
    }

    @Override
    public Token nextToken() {
    	var res = super.nextToken();
    	return tokens.isEmpty() ? res : tokens.poll();
    }

    private void jump(int ttype) {
    	indentLevel += (ttype == DEDENT ? -1 : 1);
    	CommonToken t = new CommonToken(ttype, ttype == DEDENT ? "Dedent"
    			: "Indent");
    	if (lastAdded != null) {
    		t.setLine(lastAdded.getLine());
    		t.setCharPositionInLine(lastAdded.getCharPositionInLine());
    	}
    	emit(t);
    }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PythonLexer() {} 
    public PythonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PythonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\ANTLR\\Python\\Python.g"; }

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:38:7: ( '(' )
            // C:\\ANTLR\\Python\\Python.g:38:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:39:7: ( ')' )
            // C:\\ANTLR\\Python\\Python.g:39:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:40:7: ( ',' )
            // C:\\ANTLR\\Python\\Python.g:40:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:41:7: ( ':' )
            // C:\\ANTLR\\Python\\Python.g:41:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:42:7: ( '=' )
            // C:\\ANTLR\\Python\\Python.g:42:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:43:7: ( 'None' )
            // C:\\ANTLR\\Python\\Python.g:43:9: 'None'
            {
            match("None"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:44:7: ( '[' )
            // C:\\ANTLR\\Python\\Python.g:44:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:45:7: ( ']' )
            // C:\\ANTLR\\Python\\Python.g:45:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:46:7: ( 'break' )
            // C:\\ANTLR\\Python\\Python.g:46:9: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:47:7: ( 'continue' )
            // C:\\ANTLR\\Python\\Python.g:47:9: 'continue'
            {
            match("continue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:48:7: ( 'def' )
            // C:\\ANTLR\\Python\\Python.g:48:9: 'def'
            {
            match("def"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:49:7: ( 'elif' )
            // C:\\ANTLR\\Python\\Python.g:49:9: 'elif'
            {
            match("elif"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:50:7: ( 'else' )
            // C:\\ANTLR\\Python\\Python.g:50:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:51:7: ( 'for' )
            // C:\\ANTLR\\Python\\Python.g:51:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:52:7: ( 'if' )
            // C:\\ANTLR\\Python\\Python.g:52:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:53:7: ( 'in' )
            // C:\\ANTLR\\Python\\Python.g:53:9: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:54:7: ( 'pass' )
            // C:\\ANTLR\\Python\\Python.g:54:9: 'pass'
            {
            match("pass"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:55:7: ( 'print' )
            // C:\\ANTLR\\Python\\Python.g:55:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:56:7: ( 'range' )
            // C:\\ANTLR\\Python\\Python.g:56:9: 'range'
            {
            match("range"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:57:7: ( 'return' )
            // C:\\ANTLR\\Python\\Python.g:57:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:58:7: ( 'while' )
            // C:\\ANTLR\\Python\\Python.g:58:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken e=null;
            CommonToken WS1=null;

            // C:\\ANTLR\\Python\\Python.g:390:9: ( (e= NL )+ ( WS )? )
            // C:\\ANTLR\\Python\\Python.g:390:12: (e= NL )+ ( WS )?
            {
            // C:\\ANTLR\\Python\\Python.g:390:13: (e= NL )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\n'||LA1_0=='\r') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:390:13: e= NL
            	    {
            	    int eStart195 = getCharIndex();
            	    int eStartLine195 = getLine();
            	    int eStartCharPos195 = getCharPositionInLine();
            	    mNL(); 
            	    e = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, eStart195, getCharIndex()-1);
            	    e.setLine(eStartLine195);
            	    e.setCharPositionInLine(eStartCharPos195);


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            // C:\\ANTLR\\Python\\Python.g:390:18: ( WS )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\t'||LA2_0==' ') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:390:18: WS
                    {
                    int WS1Start198 = getCharIndex();
                    int WS1StartLine198 = getLine();
                    int WS1StartCharPos198 = getCharPositionInLine();
                    mWS(); 
                    WS1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, WS1Start198, getCharIndex()-1);
                    WS1.setLine(WS1StartLine198);
                    WS1.setCharPositionInLine(WS1StartCharPos198);


                    }
                    break;

            }



            	Token nl = new CommonToken(NL, "NL");
            	nl.setLine(e.getLine());
            	nl.setCharPositionInLine(e.getCharPositionInLine());
            	emit(nl);
            	int n = (WS1!=null?WS1.getText():null) == null ? 0 : (WS1!=null?WS1.getText():null).length();
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:410:8: ( WS )
            // C:\\ANTLR\\Python\\Python.g:410:10: WS
            {
            mWS(); 


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:415:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\n') ) {
                    alt4=1;
                }
                else {
                    alt4=2;
                }
            }
            else if ( (LA4_0=='\n') ) {
                alt4=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:415:7: ( '\\r' )? '\\n'
                    {
                    // C:\\ANTLR\\Python\\Python.g:415:7: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:415:7: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:415:20: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:419:5: ( ( ' ' | '\\t' )+ )
            // C:\\ANTLR\\Python\\Python.g:419:7: ( ' ' | '\\t' )+
            {
            // C:\\ANTLR\\Python\\Python.g:419:7: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "INDENT"
    public final void mINDENT() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:423:8: ()
            // C:\\ANTLR\\Python\\Python.g:424:3: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INDENT"

    // $ANTLR start "DEDENT"
    public final void mDEDENT() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:427:8: ()
            // C:\\ANTLR\\Python\\Python.g:428:3: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEDENT"

    // $ANTLR start "COMP"
    public final void mCOMP() throws RecognitionException {
        try {
            int _type = COMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:429:6: ( '==' | '!=' | '<' | '>' | '<=' | '>=' )
            int alt6=6;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt6=1;
                }
                break;
            case '!':
                {
                alt6=2;
                }
                break;
            case '<':
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3=='=') ) {
                    alt6=5;
                }
                else {
                    alt6=3;
                }
                }
                break;
            case '>':
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4=='=') ) {
                    alt6=6;
                }
                else {
                    alt6=4;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:429:8: '=='
                    {
                    match("=="); 



                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:429:15: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:429:22: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 4 :
                    // C:\\ANTLR\\Python\\Python.g:429:28: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 5 :
                    // C:\\ANTLR\\Python\\Python.g:429:34: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 6 :
                    // C:\\ANTLR\\Python\\Python.g:429:41: '>='
                    {
                    match(">="); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMP"

    // $ANTLR start "LOGIC"
    public final void mLOGIC() throws RecognitionException {
        try {
            int _type = LOGIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:432:7: ( 'or' | 'and' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='o') ) {
                alt7=1;
            }
            else if ( (LA7_0=='a') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:432:9: 'or'
                    {
                    match("or"); 



                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:432:16: 'and'
                    {
                    match("and"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOGIC"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:435:6: ( 'not' )
            // C:\\ANTLR\\Python\\Python.g:435:8: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:438:6: ( '+' | '-' )
            // C:\\ANTLR\\Python\\Python.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:441:6: ( '*' | '/' | '%' )
            // C:\\ANTLR\\Python\\Python.g:
            {
            if ( input.LA(1)=='%'||input.LA(1)=='*'||input.LA(1)=='/' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:444:6: ( ( '0' .. '9' )+ )
            // C:\\ANTLR\\Python\\Python.g:444:8: ( '0' .. '9' )+
            {
            // C:\\ANTLR\\Python\\Python.g:444:8: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:447:6: ( 'True' | 'False' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='T') ) {
                alt9=1;
            }
            else if ( (LA9_0=='F') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:447:8: 'True'
                    {
                    match("True"); 



                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:448:8: 'False'
                    {
                    match("False"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:451:5: ( ( '_' | 'a' .. 'z' | 'A' .. 'Z' ) ( '_' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // C:\\ANTLR\\Python\\Python.g:451:7: ( '_' | 'a' .. 'z' | 'A' .. 'Z' ) ( '_' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\ANTLR\\Python\\Python.g:451:32: ( '_' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:454:9: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:454:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // C:\\ANTLR\\Python\\Python.g:454:13: ( '0' .. '9' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    match('.'); 

                    // C:\\ANTLR\\Python\\Python.g:454:29: ( '0' .. '9' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    // C:\\ANTLR\\Python\\Python.g:454:41: ( EXPONENT )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:454:41: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:455:10: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // C:\\ANTLR\\Python\\Python.g:455:14: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    // C:\\ANTLR\\Python\\Python.g:455:26: ( EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\ANTLR\\Python\\Python.g:455:26: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:456:10: ( '0' .. '9' )+ EXPONENT
                    {
                    // C:\\ANTLR\\Python\\Python.g:456:10: ( '0' .. '9' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:460:8: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' | '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\"') ) {
                alt20=1;
            }
            else if ( (LA20_0=='\'') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:460:11: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); 

                    // C:\\ANTLR\\Python\\Python.g:460:15: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:460:17: ESC_SEQ
                    	    {
                    	    mESC_SEQ(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\ANTLR\\Python\\Python.g:460:27: ~ ( '\\\\' | '\"' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:461:9: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); 

                    // C:\\ANTLR\\Python\\Python.g:461:14: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '&')||(LA19_0 >= '(' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:461:16: ESC_SEQ
                    	    {
                    	    mESC_SEQ(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\ANTLR\\Python\\Python.g:461:26: ~ ( '\\\\' | '\\'' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    match('\''); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:466:9: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\ANTLR\\Python\\Python.g:466:11: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\ANTLR\\Python\\Python.g:466:21: ( '+' | '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='+'||LA21_0=='-') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // C:\\ANTLR\\Python\\Python.g:466:32: ( '0' .. '9' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= '0' && LA22_0 <= '9')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\ANTLR\\Python\\Python.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:471:3: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\ANTLR\\Python\\Python.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:475:9: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt23=1;
                    }
                    break;
                case 'u':
                    {
                    alt23=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt23=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:475:13: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:476:10: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:477:10: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:482:6: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\\') ) {
                int LA24_1 = input.LA(2);

                if ( ((LA24_1 >= '0' && LA24_1 <= '3')) ) {
                    int LA24_2 = input.LA(3);

                    if ( ((LA24_2 >= '0' && LA24_2 <= '7')) ) {
                        int LA24_4 = input.LA(4);

                        if ( ((LA24_4 >= '0' && LA24_4 <= '7')) ) {
                            alt24=1;
                        }
                        else {
                            alt24=2;
                        }
                    }
                    else {
                        alt24=3;
                    }
                }
                else if ( ((LA24_1 >= '4' && LA24_1 <= '7')) ) {
                    int LA24_3 = input.LA(3);

                    if ( ((LA24_3 >= '0' && LA24_3 <= '7')) ) {
                        alt24=2;
                    }
                    else {
                        alt24=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:482:10: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:483:10: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // C:\\ANTLR\\Python\\Python.g:484:10: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // C:\\ANTLR\\Python\\Python.g:489:6: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // C:\\ANTLR\\Python\\Python.g:489:10: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\ANTLR\\Python\\Python.g:491:9: ( '#' (~ ( '\\n' | '\\r' ) )* | '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='#') ) {
                alt27=1;
            }
            else if ( (LA27_0=='\"') ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // C:\\ANTLR\\Python\\Python.g:491:13: '#' (~ ( '\\n' | '\\r' ) )*
                    {
                    match('#'); 

                    // C:\\ANTLR\\Python\\Python.g:491:17: (~ ( '\\n' | '\\r' ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0 >= '\u0000' && LA25_0 <= '\t')||(LA25_0 >= '\u000B' && LA25_0 <= '\f')||(LA25_0 >= '\u000E' && LA25_0 <= '\uFFFF')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    skip();

                    }
                    break;
                case 2 :
                    // C:\\ANTLR\\Python\\Python.g:492:10: '\"\"\"' ( options {greedy=false; } : . )* '\"\"\"'
                    {
                    match("\"\"\""); 



                    // C:\\ANTLR\\Python\\Python.g:492:16: ( options {greedy=false; } : . )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='\"') ) {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1=='\"') ) {
                                int LA26_3 = input.LA(3);

                                if ( (LA26_3=='\"') ) {
                                    alt26=2;
                                }
                                else if ( ((LA26_3 >= '\u0000' && LA26_3 <= '!')||(LA26_3 >= '#' && LA26_3 <= '\uFFFF')) ) {
                                    alt26=1;
                                }


                            }
                            else if ( ((LA26_1 >= '\u0000' && LA26_1 <= '!')||(LA26_1 >= '#' && LA26_1 <= '\uFFFF')) ) {
                                alt26=1;
                            }


                        }
                        else if ( ((LA26_0 >= '\u0000' && LA26_0 <= '!')||(LA26_0 >= '#' && LA26_0 <= '\uFFFF')) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\ANTLR\\Python\\Python.g:492:44: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    match("\"\"\""); 



                    skip();

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\ANTLR\\Python\\Python.g:1:8: ( T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | NEWLINE | SPACE | COMP | LOGIC | NOT | SUM | MULT | INT | BOOL | ID | FLOAT | STRING | COMMENT )
        int alt28=34;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // C:\\ANTLR\\Python\\Python.g:1:10: T__26
                {
                mT__26(); 


                }
                break;
            case 2 :
                // C:\\ANTLR\\Python\\Python.g:1:16: T__27
                {
                mT__27(); 


                }
                break;
            case 3 :
                // C:\\ANTLR\\Python\\Python.g:1:22: T__28
                {
                mT__28(); 


                }
                break;
            case 4 :
                // C:\\ANTLR\\Python\\Python.g:1:28: T__29
                {
                mT__29(); 


                }
                break;
            case 5 :
                // C:\\ANTLR\\Python\\Python.g:1:34: T__30
                {
                mT__30(); 


                }
                break;
            case 6 :
                // C:\\ANTLR\\Python\\Python.g:1:40: T__31
                {
                mT__31(); 


                }
                break;
            case 7 :
                // C:\\ANTLR\\Python\\Python.g:1:46: T__32
                {
                mT__32(); 


                }
                break;
            case 8 :
                // C:\\ANTLR\\Python\\Python.g:1:52: T__33
                {
                mT__33(); 


                }
                break;
            case 9 :
                // C:\\ANTLR\\Python\\Python.g:1:58: T__34
                {
                mT__34(); 


                }
                break;
            case 10 :
                // C:\\ANTLR\\Python\\Python.g:1:64: T__35
                {
                mT__35(); 


                }
                break;
            case 11 :
                // C:\\ANTLR\\Python\\Python.g:1:70: T__36
                {
                mT__36(); 


                }
                break;
            case 12 :
                // C:\\ANTLR\\Python\\Python.g:1:76: T__37
                {
                mT__37(); 


                }
                break;
            case 13 :
                // C:\\ANTLR\\Python\\Python.g:1:82: T__38
                {
                mT__38(); 


                }
                break;
            case 14 :
                // C:\\ANTLR\\Python\\Python.g:1:88: T__39
                {
                mT__39(); 


                }
                break;
            case 15 :
                // C:\\ANTLR\\Python\\Python.g:1:94: T__40
                {
                mT__40(); 


                }
                break;
            case 16 :
                // C:\\ANTLR\\Python\\Python.g:1:100: T__41
                {
                mT__41(); 


                }
                break;
            case 17 :
                // C:\\ANTLR\\Python\\Python.g:1:106: T__42
                {
                mT__42(); 


                }
                break;
            case 18 :
                // C:\\ANTLR\\Python\\Python.g:1:112: T__43
                {
                mT__43(); 


                }
                break;
            case 19 :
                // C:\\ANTLR\\Python\\Python.g:1:118: T__44
                {
                mT__44(); 


                }
                break;
            case 20 :
                // C:\\ANTLR\\Python\\Python.g:1:124: T__45
                {
                mT__45(); 


                }
                break;
            case 21 :
                // C:\\ANTLR\\Python\\Python.g:1:130: T__46
                {
                mT__46(); 


                }
                break;
            case 22 :
                // C:\\ANTLR\\Python\\Python.g:1:136: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 23 :
                // C:\\ANTLR\\Python\\Python.g:1:144: SPACE
                {
                mSPACE(); 


                }
                break;
            case 24 :
                // C:\\ANTLR\\Python\\Python.g:1:150: COMP
                {
                mCOMP(); 


                }
                break;
            case 25 :
                // C:\\ANTLR\\Python\\Python.g:1:155: LOGIC
                {
                mLOGIC(); 


                }
                break;
            case 26 :
                // C:\\ANTLR\\Python\\Python.g:1:161: NOT
                {
                mNOT(); 


                }
                break;
            case 27 :
                // C:\\ANTLR\\Python\\Python.g:1:165: SUM
                {
                mSUM(); 


                }
                break;
            case 28 :
                // C:\\ANTLR\\Python\\Python.g:1:169: MULT
                {
                mMULT(); 


                }
                break;
            case 29 :
                // C:\\ANTLR\\Python\\Python.g:1:174: INT
                {
                mINT(); 


                }
                break;
            case 30 :
                // C:\\ANTLR\\Python\\Python.g:1:178: BOOL
                {
                mBOOL(); 


                }
                break;
            case 31 :
                // C:\\ANTLR\\Python\\Python.g:1:183: ID
                {
                mID(); 


                }
                break;
            case 32 :
                // C:\\ANTLR\\Python\\Python.g:1:186: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 33 :
                // C:\\ANTLR\\Python\\Python.g:1:192: STRING
                {
                mSTRING(); 


                }
                break;
            case 34 :
                // C:\\ANTLR\\Python\\Python.g:1:199: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA17_eotS =
        "\5\uffff";
    static final String DFA17_eofS =
        "\5\uffff";
    static final String DFA17_minS =
        "\2\56\3\uffff";
    static final String DFA17_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA17_specialS =
        "\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "454:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA28_eotS =
        "\5\uffff\1\42\1\35\2\uffff\11\35\3\uffff\3\35\2\uffff\1\63\2\35"+
        "\6\uffff\6\35\1\76\1\77\5\35\1\105\2\35\1\uffff\2\35\1\40\3\35\1"+
        "\115\2\35\1\120\2\uffff\5\35\1\uffff\1\105\1\126\2\35\1\131\2\35"+
        "\1\uffff\1\134\1\135\1\uffff\1\136\4\35\1\uffff\1\143\1\35\1\uffff"+
        "\1\145\1\35\3\uffff\1\147\1\150\1\35\1\152\1\uffff\1\143\1\uffff"+
        "\1\35\2\uffff\1\154\1\uffff\1\35\1\uffff\1\156\1\uffff";
    static final String DFA28_eofS =
        "\157\uffff";
    static final String DFA28_minS =
        "\1\11\4\uffff\1\75\1\157\2\uffff\1\162\1\157\1\145\1\154\1\157\1"+
        "\146\2\141\1\150\3\uffff\1\162\1\156\1\157\2\uffff\1\56\1\162\1"+
        "\141\2\uffff\1\0\3\uffff\1\156\1\145\1\156\1\146\1\151\1\162\2\60"+
        "\1\163\1\151\1\156\1\164\1\151\1\60\1\144\1\164\1\uffff\1\165\1"+
        "\154\1\42\1\145\1\141\1\164\1\60\1\146\1\145\1\60\2\uffff\1\163"+
        "\1\156\1\147\1\165\1\154\1\uffff\2\60\1\145\1\163\1\60\1\153\1\151"+
        "\1\uffff\2\60\1\uffff\1\60\1\164\1\145\1\162\1\145\1\uffff\1\60"+
        "\1\145\1\uffff\1\60\1\156\3\uffff\2\60\1\156\1\60\1\uffff\1\60\1"+
        "\uffff\1\165\2\uffff\1\60\1\uffff\1\145\1\uffff\1\60\1\uffff";
    static final String DFA28_maxS =
        "\1\172\4\uffff\1\75\1\157\2\uffff\1\162\1\157\1\145\1\154\1\157"+
        "\1\156\1\162\1\145\1\150\3\uffff\1\162\1\156\1\157\2\uffff\1\145"+
        "\1\162\1\141\2\uffff\1\uffff\3\uffff\1\156\1\145\1\156\1\146\1\163"+
        "\1\162\2\172\1\163\1\151\1\156\1\164\1\151\1\172\1\144\1\164\1\uffff"+
        "\1\165\1\154\1\42\1\145\1\141\1\164\1\172\1\146\1\145\1\172\2\uffff"+
        "\1\163\1\156\1\147\1\165\1\154\1\uffff\2\172\1\145\1\163\1\172\1"+
        "\153\1\151\1\uffff\2\172\1\uffff\1\172\1\164\1\145\1\162\1\145\1"+
        "\uffff\1\172\1\145\1\uffff\1\172\1\156\3\uffff\2\172\1\156\1\172"+
        "\1\uffff\1\172\1\uffff\1\165\2\uffff\1\172\1\uffff\1\145\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\2\uffff\1\7\1\10\11\uffff\1\26\1\27\1\30"+
        "\3\uffff\1\33\1\34\3\uffff\1\37\1\40\1\uffff\1\41\1\42\1\5\20\uffff"+
        "\1\35\12\uffff\1\17\1\20\5\uffff\1\31\7\uffff\1\13\2\uffff\1\16"+
        "\5\uffff\1\32\2\uffff\1\6\2\uffff\1\14\1\15\1\21\4\uffff\1\36\1"+
        "\uffff\1\11\1\uffff\1\22\1\23\1\uffff\1\25\1\uffff\1\24\1\uffff"+
        "\1\12";
    static final String DFA28_specialS =
        "\37\uffff\1\0\117\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\23\1\22\2\uffff\1\22\22\uffff\1\23\1\24\1\37\1\41\1\uffff"+
            "\1\31\1\uffff\1\40\1\1\1\2\1\31\1\30\1\3\1\30\1\36\1\31\12\32"+
            "\1\4\1\uffff\1\24\1\5\1\24\2\uffff\5\35\1\34\7\35\1\6\5\35\1"+
            "\33\6\35\1\7\1\uffff\1\10\1\uffff\1\35\1\uffff\1\26\1\11\1\12"+
            "\1\13\1\14\1\15\2\35\1\16\4\35\1\27\1\25\1\17\1\35\1\20\4\35"+
            "\1\21\3\35",
            "",
            "",
            "",
            "",
            "\1\24",
            "\1\43",
            "",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51\7\uffff\1\52",
            "\1\53\20\uffff\1\54",
            "\1\55\3\uffff\1\56",
            "\1\57",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "",
            "\1\36\1\uffff\12\32\13\uffff\1\36\37\uffff\1\36",
            "\1\64",
            "\1\65",
            "",
            "",
            "\42\40\1\66\uffdd\40",
            "",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73\11\uffff\1\74",
            "\1\75",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\106",
            "\1\107",
            "",
            "\1\110",
            "\1\111",
            "\1\41",
            "\1\112",
            "\1\113",
            "\1\114",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\116",
            "\1\117",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\127",
            "\1\130",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\132",
            "\1\133",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\144",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\146",
            "",
            "",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\151",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\153",
            "",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\155",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | NEWLINE | SPACE | COMP | LOGIC | NOT | SUM | MULT | INT | BOOL | ID | FLOAT | STRING | COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_31 = input.LA(1);

                        s = -1;
                        if ( (LA28_31=='\"') ) {s = 54;}

                        else if ( ((LA28_31 >= '\u0000' && LA28_31 <= '!')||(LA28_31 >= '#' && LA28_31 <= '\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}