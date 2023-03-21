package com.pluralsight.annotations.calcengine.bad;

public class Main {
	public MathProcessing retrieveProcessor(String keyword) {
		switch (keyword) {
			case "add": {
				return new Adder();
			}
			case "subtract": {
				return new Subtracter();
			}
			case "multipy": {
				return new Multiplier();
			}
			case "divide": {
				return new Divider();
			}
		}
		return null;
	}
}
