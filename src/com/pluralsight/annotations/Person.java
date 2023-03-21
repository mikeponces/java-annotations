package com.pluralsight.annotations;

public class Person implements Comparable<Person>{
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override // - This annotation specifies my INTENT to use compareTo for sorting
	public int compareTo(Person o) {

		return this.name.compareTo(o.name);
	}

	// Even if your intent was to override, the compiler cannot catch this
	@Override
	public String toString() {
		return name;
	}
}
