package com.dt.tutorial.java8.lesson1;

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [ name = " + String.format("%1$-14s", name) + ", age = " + age + " ]";
	}
}
