package com.pluralsight.annotations.calcengine.bad;

public class Divider implements MathProcessing {

	@Override
	public double doCalculation(double leftVal, double rightVal) {
		return leftVal / rightVal;
	}

}
