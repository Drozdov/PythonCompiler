package ru.ifmo.ctddev.drozdov.python;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import ru.ifmo.ctddev.drozdov.python.operations.Operation;
import ru.ifmo.ctddev.drozdov.python.operations.OperationException;

public class Executor {

	private boolean debug = false;
	private PrintStream out = System.out;
	private Stack<Object> stack = new Stack<>();
	
	private class Context {
		private Map<String, Object> vars = new HashMap<>();
		private int current;
		
		private Context(int current) {
			this.current = current;
		}
	}
	
	private Stack<Context> contexts = new Stack<>();
	private Context cur;
	
	public void setPrintStream(PrintStream out) {
		this.out = out;
	}
	
	public void exec(InputStream stream) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		List<String> commands = new ArrayList<>();
		String line;
		while ((line = in.readLine()) != null) {
			commands.add(line);
		}
		cur = new Context(0);
		while (cur.current < commands.size()) {
			cur.current++;
			exec(commands.get(cur.current - 1));
		}
	}
	
	private Object get(String key) {
		Context c = cur;
		int i = contexts.size() - 1;
		while (!c.vars.containsKey(key) && i >= 0) {
			c = contexts.get(i--);
		}
		return c.vars.get(key);
	}
	
	private void exec(String command) {
		String operands[] = command.split("\\s+");
		if (debug) {
			System.err.println(command);
		}
		switch (operands[0]) {
		case "cp":
		case "=":
			cur.vars.put(operands[1], get(operands[2]));
			break;
		case "mv":
			Object value;
			String val = operands[2].substring(1);
			switch (operands[2].charAt(0)) {
			case 'N':
				value = null;
				break;
			case 'I':
				value = new Integer(val);
				break;
			case 'F':
				value = new Double(val);
				break;
			case 'B':
				value = new Boolean(val);
				break;
			default:
				value = val;
			}
			cur.vars.put(operands[1], value);
			break;
		case "pr":
			Object tmp = get(operands[1]);
			if (tmp == null) {
				out.println("None");
			} else if (tmp instanceof Boolean) {
				if ((boolean) tmp)
					out.println("True");
				else
					out.println("False");
			} else {
				out.println(tmp.toString().replaceAll("([^\\\\])\\\\s", "$1 ").
						replaceAll("\\\\t", "	").replaceAll("\\\\(\\\\)", "$1"));
			}
			break;
		case "jn":
			if ((boolean) get(operands[1]))
				break;
		case "jmp":
			cur.current = new Integer(operands[operands.length - 1]);
			break;
		case "push":
			stack.push(get(operands[1]));
			break;
		case "pop":
			cur.vars.put(operands[1], stack.pop());
			break;
		case "call":
			if (operands[1].matches("\\d+")) {
				contexts.push(cur);
				cur = new Context(new Integer(operands[1]));
			} else {
				NativeFunction func = NativeFunction.NATIVE_FUNCS.get(operands[1]);
				List<Object> args = new ArrayList<>();
				for (int i = 0; i < func.operandsNumber(); i++) {
					args.add(stack.pop());
				}
				stack.push(func.foo(args));
			}
			break;
		case "ret":
			cur = contexts.pop();
			break;
		default:
			Operation op = Operation.getOperation(operands[0]);
			try {
				Object res = op.operate(operands[0], get(operands[1]), get(operands[2]));
				cur.vars.put(operands[1], res);
			} catch (OperationException e) {
				System.err.println(e.getMessage());
				System.exit(0);
			}
		}
	}
}
