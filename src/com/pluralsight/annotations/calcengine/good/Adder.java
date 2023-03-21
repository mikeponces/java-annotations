package com.pluralsight.annotations.calcengine.good;

@CommandKeyword(name="add")
// @CommandKeyword("add") - value
public class Adder implements MathProcessing {

	@Override
	public double doCalculation(double leftVal, double rightVal) {
		return leftVal + rightVal;
	}

}
