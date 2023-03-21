package com.pluralsight.annotations.calcengine.good;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();

		System.out.println(main.retrieveProcessor("add").map(mp -> mp.doCalculation(10, 10)).orElseThrow());

		System.out.println(main.doCalculation("add", 10, 10));
	}

	public Optional<MathProcessing> retrieveProcessor(String keyword) {
		Stream<MathProcessing> mathProcessors = Stream.of(new Adder(), new Subtracter(), new Multiplier(),
				new Divider());

		return mathProcessors
				.filter(mp -> keyword.equalsIgnoreCase(mp.getClass().getAnnotation(CommandKeyword.class).name()))
				.findFirst();
	}

	public double doCalculation(String keyword, double leftVal, double rightVal) {
		Stream<MathProcessing> mathProcessors = Stream.of(new Adder(), new Subtracter(), new Multiplier(),
				new Divider());

		return (double) mathProcessors
				.filter(mp -> keyword.equalsIgnoreCase(mp.getClass().getAnnotation(CommandKeyword.class).name()))
				.findFirst()
				.map(mp -> {
					Method method;
					try {
						String methodName = mp.getClass().getAnnotation(CommandKeyword.class).method();
						method = mp.getClass().getMethod(methodName, double.class, double.class);
						return method.invoke(mp, leftVal, rightVal);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
					return 0;
				}).orElseThrow();
	}
}
