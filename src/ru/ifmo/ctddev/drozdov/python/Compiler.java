package ru.ifmo.ctddev.drozdov.python;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import ru.ifmo.ctddev.drozdov.python.operations.Operation;
import ru.ifmo.ctddev.drozdov.python.parsing.PythonLexer;
import ru.ifmo.ctddev.drozdov.python.parsing.PythonParser;
import ru.ifmo.ctddev.drozdov.python.parsing.PythonParser.ParsingManager;

public class Compiler extends PythonParser implements ParsingManager {

	public static void main(String[] args) throws IOException {
		PythonLexer lex = new PythonLexer(new ANTLRFileStream(
				"input.txt", "UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Compiler compiler = new Compiler(tokens);
		compiler.generateCode(new PrintStream("test.out"));
	}
	
	private boolean ok = true;
	
	public Compiler(TokenStream input) {
		super(input);
		setManager(this);
	}
	
	public void reportError(RecognitionException e) {
		if (e instanceof CommonException) {
			e.charPositionInLine = getCurrentPosition().pos;
			e.line = getCurrentPosition().line;
			System.err.println(this.getErrorHeader(e) + " "
					+ (e.getMessage()));
		} else {
			super.reportError(e);
		}
	}
	
	public void recover(IntStream in, RecognitionException re) {
		super.recover(in, re);
		ok = false;
	}
	
	public boolean generateCode(PrintStream out) {
		ok = true;
		try {
			parse();
		} catch (RecognitionException e) {
			reportError(e);
			ok = false;
		}
		if (ok)
			flush(out);
		return ok;
	}
	
	private class If {
	int condition, position;

		public If(int condition, int position) {
			this.condition = condition;
			this.position = position;
		}
		
	}
	
	private class CommonException extends RecognitionException {
		private static final long serialVersionUID = 1L;
		public String message;
		public CommonException(IntStream input, String message) {
			super(input);
			this.message = message;
		}
		
		@Override
		public String getMessage() {
			return message;
		}
	}
	
	private int currentFree = 0;
	private List<String> operations = new ArrayList<>();
	private Stack<Integer> cycles = new Stack<>();
	private Stack<If> ifs = new Stack<>();
	private Stack<List<Integer>> breaks = new Stack<>();
	private Stack<List<Integer>> ifExits = new Stack<>();
	private Map<String, Integer> functionJumps = new HashMap<>();
	private int curFunctionJump = -1;
	
	@Override
	public int getVariable(String option, int id1, int id2)
			throws RecognitionException {
		int res = id1;
		currentFree = id1 + 1;
		if (Operation.getOperation(option) == null) {
			throw new CommonException(input, "unknown option: " + option);
		}
		operations.add(option + " " + id1 + " " + id2);
		return res;
	}

	@Override
	public int getVariable(Object value) throws RecognitionException {
		int res = currentFree++;
		String prefix;
		if (value == null) {
			prefix = "N";
		} else if (value instanceof Double) {
			prefix = "F";
		} else if (value instanceof Boolean) {
			prefix = "B";
		} else if (value instanceof Integer) {
			prefix = "I";
		} else {
			prefix = "S";
			value = value.toString().replaceAll("\\\\", "\\\\\\\\")
					.replaceAll(" ", "\\\\s").replaceAll("	", "\\\\t");
		}
		operations.add("mv " + res + " " + prefix + value);
		return res;
	}

	@Override
	public int getVariableByName(String name) throws RecognitionException {
		int res = currentFree++;
		operations.add("cp " + res + " " + name);
		return res;
	}

	@Override
	public int getVariableByFunctionCall(String functionName, List<Integer> args)
			throws RecognitionException {
		for (int reg : args) {
			operations.add("push " + reg);
		}
		String name = args.size() + functionName;
		if (functionJumps.containsKey(name)) {
			operations.add("call " + functionJumps.get(name));
		} else if (NativeFunction.NATIVE_FUNCS.containsKey(name)) {
			operations.add("call " + name);
		} else {
			throw new CommonException(input, 
					String.format("function not declared: %s(%d)", functionName, args.size()));
		}
		if (args.size() > 0) 
			currentFree = args.get(0);
		int res = currentFree++;
		operations.add("pop " + res);
		return res;
	}

	@Override
	public void startFunctionDeclaration(String functionName, List<String> args)
			throws RecognitionException {
		operations.add(new String());
		curFunctionJump = operations.size();
		functionJumps.put(args.size() + functionName, curFunctionJump);
		for (int j = args.size() - 1; j >= 0; j--) {
			operations.add("pop " + args.get(j));
		}
	}

	@Override
	public void endFunctionDeclaration() throws RecognitionException {
		returnStatement(-1);
		operations.set(curFunctionJump - 1, "jmp " + operations.size());
		curFunctionJump = -1;
	}

	@Override
	public void returnStatement(int id) throws RecognitionException {
		if (curFunctionJump < 0)
			throw new CommonException(input, "No function for return statement");
		operations.add("push " + id);
		operations.add("ret");
	}

	@Override
	public void print(int id) throws RecognitionException {
		operations.add("pr " + id);
		currentFree = 0;
	}

	@Override
	public void assign(String strId, int id) throws RecognitionException {
		operations.add("= " + strId + " " + id);
		currentFree = 0;
	}

	@Override
	public void startCycle() throws RecognitionException {
		cycles.push(operations.size());
		breaks.push(new ArrayList<Integer>());
	}

	@Override
	public void stopCycle() throws RecognitionException {
		operations.add("jmp " + cycles.pop());
		for (int br : breaks.pop()) {
			operations.set(br, "jmp " + operations.size());
		}
	}

	@Override
	public void breakCycle() throws RecognitionException {
		if (breaks.isEmpty())
			throw new CommonException(input, "No cycle to break");
		breaks.peek().add(operations.size());
		operations.add(new String());
	}

	@Override
	public void continueCycle() throws RecognitionException {
		if (breaks.isEmpty())
			throw new CommonException(input, "No cycle to continue");
		operations.add("jmp " + cycles.peek());
	}

	@Override
	public void startIf(int condition) throws RecognitionException {
		ifs.push(new If(condition, operations.size()));
		ifExits.push(new ArrayList<Integer>());
		operations.add(new String());
	}

	@Override
	public void startElse() throws RecognitionException {
		ifExits.peek().add(operations.size());
		operations.add(new String());
		If iff = ifs.pop();
		operations.set(iff.position, "jn " + iff.condition + " " + operations.size());
		ifs.push(null);
	}
	
	@Override
	public void startElif(int condition) throws RecognitionException {
		ifs.pop();
		ifs.push(new If(condition, operations.size()));
		operations.add(new String());
	}

	@Override
	public void stopIf() throws RecognitionException {
		If iff = ifs.pop();
		if (iff != null)
			operations.set(iff.position, "jn " + iff.condition + " " + operations.size());
		List<Integer> ife = ifExits.pop();
		for (int ifexit : ife)
			operations.set(ifexit, "jmp " + operations.size());
	}
	
	public void flush(PrintStream out) {
		for (String s : operations) {
			out.println(s);
		}
	}

}
