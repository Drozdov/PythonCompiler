package ru.ifmo.ctddev.drozdov.python;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import ru.ifmo.ctddev.drozdov.python.parsing.PythonLexer;

public class Main {

	public static void main(String[] args) throws IOException {
		PythonLexer lex = new PythonLexer(new ANTLRFileStream(
				"demo2.py", "UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Compiler compiler = new Compiler(tokens);
		compiler.generateCode(new PrintStream("test.out"));

		new Executor().exec(new FileInputStream("test.out"));
	}

}
