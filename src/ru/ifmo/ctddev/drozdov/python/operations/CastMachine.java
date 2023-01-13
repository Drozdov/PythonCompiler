package ru.ifmo.ctddev.drozdov.python.operations;

public class CastMachine {
	public Object v1, v2;

	public CastMachine(Object v1, Object v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public void castToEqual() {
		castToInt();
		if (argsEqual())
			return;
		castToFloat();
	}
	
	public boolean argsEqual() {
		return v2 == null || v1.getClass().equals(v2.getClass());
	}
	
	public void castToBool() {
		if (v1 instanceof Number) {
			v1 = ((Number)v1).intValue() != 0 ? true : false;
		}
		if (v2 instanceof Number) {
			v2 = ((Number)v2).intValue() != 0 ? true : false;
		}
	}
	
	public void castToInt() {
		if (v1 instanceof Boolean) {
			v1 = (Boolean)v1 ? 1 : 0;
		}
		if (v2 instanceof Boolean) {
			v2 = (Boolean)v2 ? 1 : 0;
		}
	}
	
	public void castToFloat() {
		if (v1 instanceof Integer) {
			v1 = ((Integer)v1).doubleValue();
		}
		if (v2 instanceof Integer) {
			v2 = ((Integer)v2).doubleValue();
		}
	}
	
}
