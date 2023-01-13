package ru.ifmo.ctddev.drozdov.python.operations;

public enum Operation {
	PLUS {
		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			CastMachine cm = new CastMachine(v1, v2);
			cm.castToEqual();
			if (!cm.argsEqual())
				throw new OperationException("Cannot concatenate "
						+ v1.getClass() + " and " + v2.getClass());
			if (cm.v1 instanceof String) {
				return (String) cm.v1 + (String) cm.v2;
			}
			if (cm.v1 instanceof Integer) {
				return (Integer) cm.v1 + (Integer) cm.v2;
			}
			return (Double) cm.v1 + (Double) cm.v2;
		}

	},
	MINUS {

		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			CastMachine cm = new CastMachine(v1, v2);
			cm.castToEqual();
			if (!cm.argsEqual() || cm.v1 instanceof String)
				throw new OperationException("Cannot subtract " + v1.getClass()
						+ " and " + v2.getClass());
			if (cm.v1 instanceof Integer) {
				return cm.v2 != null ? (Integer) cm.v1 - (Integer) cm.v2 : -(Integer)cm.v1;
			}
			return cm.v2 != null ? (Double) cm.v1 - (Double) cm.v2 : -(Double)cm.v1;
		}

	},
	MULTIPLY {
		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			CastMachine cm = new CastMachine(v1, v2);
			if (v1 instanceof String && v2 instanceof Integer) {
				return multiply((String)v1, (int) v2);
			}
			cm.castToEqual();
			if (!cm.argsEqual())
				throw new OperationException("Cannot multiply " + v1.getClass()
						+ " and " + v2.getClass());

			if (cm.v1 instanceof Integer) {
				return (Integer) cm.v1 * (Integer) cm.v2;
			}
			return (Double) cm.v1 * (Double) cm.v2;
		}

		private String multiply(String v1, int v2) {
			StringBuffer res = new StringBuffer();
			for (int i = 0; i < v2; i++) {
				res.append(v1);
			}
			return res.toString();
		}

	},
	DIVIDE {

		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			if (!option.matches("/|%"))
				throw new OperationException("Operation is not a devision: " + option);
			CastMachine cm = new CastMachine(v1, v2);
			cm.castToEqual();
			if (cm.argsEqual()) {
				if (option.equals("/")) {
					if (cm.v1 instanceof Integer) {
						return (Integer) cm.v1 / (Integer) cm.v2;
					}
					return (Double) cm.v1 / (Double) cm.v2;
				} else {
					if (cm.v1 instanceof Integer) {
						return (Integer) cm.v1 % (Integer) cm.v2;
					}
					return (Double) cm.v1 % (Double) cm.v2;
				}
			}
			throw new OperationException("Cannot multiply " + v1.getClass()
					+ " and " + v2.getClass());
		}
		
	},
	
	COMPARE {

		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			CastMachine cm = new CastMachine(v1, v2);
			cm.castToEqual();
			double cmp;
			if (v1 instanceof String || v2 instanceof String) {
				if (v1 instanceof String && v2 instanceof String) {
					cmp = ((String) v1).compareTo((String) v2);
				} else {
					cmp = (v1 instanceof String) ? 1 : -1;
				}
			} else if (cm.v1 instanceof Number && cm.v2 instanceof Number) {
				cmp = (((Number) cm.v1).doubleValue() - ((Number) cm.v2)
						.doubleValue());
			} else {
				throw new OperationException("Cannot compare " + v1.getClass()
						+ " " + v2.getClass());
			}
			switch (option) {
			case "<":
				return cmp < 0;
			case "<=":
				return cmp <= 0;
			case ">":
				return cmp > 0;
			case ">=":
				return cmp >= 0;
			case "==":
				return cmp == 0;
			default:
				throw new OperationException("Operation is not a comparation: "
						+ option);
			}
		}

	},
	
	BOOL {

		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			CastMachine cm = new CastMachine(v1, v2);
			cm.castToBool();
			if (cm.v1 instanceof Boolean && (cm.v2 == null || cm.v2 instanceof Boolean)) {
				switch (option) {
				case "not":
					return !(Boolean)cm.v1;
				case "and":
					if (cm.v1 != null)
						return (Boolean)cm.v1 && (Boolean)cm.v2;
				case "or":
					if (cm.v2 != null)
						return (Boolean)cm.v1 || (Boolean)cm.v2;
					throw new OperationException(option + 
							" is not appliable with second argument null.");
				default:
					throw new OperationException(option + 
							" is not a boolean operation.");
				}
			}
			throw new OperationException(option + " cannot be calculated with the values" +
					v1.getClass() + " and " + v2.getClass());
		}
		
	},
	
	STR {

		@Override
		public Object operate(String option, Object v1, Object v2)
				throws OperationException {
			if (!(v1 instanceof String && v2 instanceof Integer)) {
				throw new OperationException("[] cannot be calculated with the values " +
						v1.getClass().getSimpleName() + " and " + v2.getClass().getSimpleName());
			}
			String str = (String)v1;
			int par = (Integer)v2;
			switch(option) {
			case "[":
				if (par > str.length())
					return "";
				if (par < 0)
					return str;
				return str.substring(par);
			case "]":
				if (par > str.length())
					return str;
				if (par < 0)
					return "";
				return str.substring(0, par);
			case ":":
				String result = "";
				if (par == 0)
					throw new OperationException("slice step cannot be zero");
				if (par < 0) {
					String tmp = "";
					for (int i = str.length() - 1; i >= 0; i--) {
						tmp += str.charAt(i);
					}
					str = tmp;
					par *= -1;
				}
				for (int i = 0; i < str.length(); i += par) {
					result += str.charAt(i);
				}
				return result;
			}
			throw new OperationException(option + " is not a string operation");
		}
		
	};

	public abstract Object operate(String option, Object v1, Object v2)
			throws OperationException;

	public static Operation getOperation(String option) {
		switch (option) {
		case "+":
			return Operation.PLUS;
		case "-":
			return Operation.MINUS;
		case "*":
			return Operation.MULTIPLY;
		case "/":
		case "%":
			return Operation.DIVIDE;
		case "<":
		case "<=":
		case ">":
		case ">=":
		case "==":
			return Operation.COMPARE;
		case "or":
		case "and":
		case "not":
			return Operation.BOOL;
		case "[":
		case "]":
		case ":":
			return Operation.STR;
		default:
			return null;
		}
	}

}