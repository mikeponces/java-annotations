package com.pluralsight.annotations;

public class MyWorker {

	@SuppressWarnings("deprecation")
	void doSomeWork() {
		Doer d1 = new Doer();
		d1.doTheThing();
	}

	@SuppressWarnings("deprecation")
	void doDoubleWork() {
		Doer d1 = new Doer();
		d1.doTheThing();
		d1.doTheThing();
	}
}
