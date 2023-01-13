package ru.ifmo.ctddev.drozdov.python;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.RecognitionException;

import ru.ifmo.ctddev.drozdov.python.operations.Operation;
import ru.ifmo.ctddev.drozdov.python.parsing.PythonParser;

/**
 * Simple python interpreter for parsing expressions and assigning values
 * @author Vladimir Drozdov
 *
 */
public class SimpleInterpreter implements PythonParser.ParsingManager {

	private Map<String, Integer> variables = new HashMap<>();
	private List<Object> vars = new ArrayList<>();	
	
	@Override
	public int getVariable(String option, int id1, int id2) throws RecognitionException {
		Operation operation = Operation.getOperation(option);
		try {
			Object res = operation.operate(option, vars.get(id1), id2 >= 0 ? vars.get(id2) : null);
			vars.add(res);
			return vars.size() - 1;
		} catch (Exception e) { 
			System.err.println(e.getMessage());
			throw new RecognitionException();
		}
	}

	@Override
	public int getVariable(Object value) {
		vars.add(value);
		return vars.size() - 1;
	}

	@Override
	public int getVariableByName(String name) {
		if (variables.containsKey(name))
			return variables.get(name);
		return -1;
	}

	@Override
	public int getVariableByFunctionCall(String functionName, List<Integer> args) {
		return -1;
	}

	@Override
	public void print(int id) {
		System.out.println(vars.get(id));
	}

	@Override
	public void assign(String strId, int id) {
		variables.put(strId, id);		
	}

	@Override
	public void startCycle() {
	}

	@Override
	public void stopCycle() {
	}

	@Override
	public void breakCycle() {
	}

	@Override
	public void continueCycle() {
	}

	@Override
	public void startIf(int condition) {
	}

	@Override
	public void startElse() {
	}

	@Override
	public void stopIf() {
	}

	@Override
	public void startElif(int condition) throws RecognitionException {
	}

	@Override
	public void startFunctionDeclaration(String functionName, List<String> args)
			throws RecognitionException {
	}

	@Override
	public void endFunctionDeclaration() throws RecognitionException {
	}

	@Override
	public void returnStatement(int id) throws RecognitionException {
	}

}
