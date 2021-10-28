package com.udemy.ciklum.the_collections_framework.lecture27;

import java.util.Objects;

public class Animal2 {
	String name;
	int age;
	
	public Animal2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal2))
			return false;
		Animal2 other = (Animal2) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
}
