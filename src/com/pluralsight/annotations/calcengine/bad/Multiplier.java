package com.pluralsight.annotations.calcengine.bad;

public class Multiplier implements MathProcessing {

	@Override
	public double doCalculation(double leftVal, double rightVal) {
		return leftVal * rightVal;
	}

}
