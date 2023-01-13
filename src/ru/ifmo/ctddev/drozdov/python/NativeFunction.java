package ru.ifmo.ctddev.drozdov.python;

import java.util.*;

public abstract class NativeFunction {
	public abstract Object foo(List<Object> args);
	public abstract int operandsNumber();
	
	public final static Map<String, NativeFunction> NATIVE_FUNCS = nativeFuncs();

	private final static Random random = new Random(239);

	private static Scanner in = new Scanner(System.in);
			
	private static Map<String, NativeFunction> nativeFuncs() {
		 Map<String, NativeFunction> res = new HashMap<>();

		 res.put("0random", new NativeFunction() {
			 @Override
			 public Object foo(List<Object> args) {
				 return random.nextDouble();
			 }

			 @Override
			 public int operandsNumber() {
				 return 0;
			 }
		 });

		 res.put("0raw_input", new NativeFunction() {
			
			@Override
			public Object foo(List<Object> args) {
				return in.nextLine();
			}

			@Override
			public int operandsNumber() {
				return 0;
			}
		 });

		 res.put("1str", new NativeFunction() {
			
			@Override
			public Object foo(List<Object> args) {
				return args.get(0).toString();
			}

			@Override
			public int operandsNumber() {
				return 1;
			}
		});
		return res;
	}
}
