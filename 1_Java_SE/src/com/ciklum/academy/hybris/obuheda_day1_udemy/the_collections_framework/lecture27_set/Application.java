package com.ciklum.academy.hybris.obuheda_day1_udemy.the_collections_framework.lecture27_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = null;

	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture27");
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
	}
	
	private static void example1() {
		logger.info("example1 - HashSet<Integer>");
		Set<Integer> values = new HashSet<Integer>();
		values.add(12);
		values.add(43);
		values.add(15);
		values.add(67);
		values.add(43);

		for (Integer value : values) {
			logger.trace(value);
		};
	}
	
	private static void example2() {
		logger.info("\nexample2 - HashSet<String>");
		Set<String> values = new HashSet<String>();
		values.add("Random");
		values.add("People");
		values.add("Animal");
		values.add("Random");
		values.add("Random");
		values.add("Zoo");
		values.add("Car");
		
		for (String value : values) {
			logger.trace(value);
		};
	}
	
	private static void example3() {
		logger.info("\nexample3 - LinkedHashSet");
		Set<String> values = new LinkedHashSet<String>();
		values.add("Random");
		values.add("People");
		values.add("Animal");
		values.add("Zoo");
		values.add("Car");


		for (String value : values) {
			logger.trace(value);
		};
	}
	
	private static void example4() {
		logger.info("\nexample4 - Animal Double");
		Set<Animal> animals = new HashSet<Animal>();
		animals.add(new Animal("dog", 12));
		animals.add(new Animal("cat", 8));
		animals.add(new Animal("bird", 3));
		animals.add(new Animal("dog", 12));
		animals.add(new Animal("kangaroo", 24));

		for (Animal animal : animals) {
			logger.trace(animal);
		};
	}
	
	private static void example5() {
		logger.info("\nexample5 - Animal object not double");
		Set<Animal> animals = new HashSet<Animal>();
		Animal dog = new Animal("dog", 12);
		animals.add(dog);
		animals.add(new Animal("cat", 8));
		animals.add(new Animal("bird", 3));
		animals.add(dog);
		animals.add(new Animal("kangaroo", 24));

		for (Animal animal : animals) {
			logger.trace(animal);
		};
	}
	
	private static void example6() {
		logger.info("\nexample6 - Animal with equals");
		Set<Animal2> animals = new HashSet<Animal2>();
		animals.add(new Animal2("dog", 12));
		animals.add(new Animal2("cat", 8));
		animals.add(new Animal2("bird", 3));
		animals.add(new Animal2("dog", 12));
		animals.add(new Animal2("kangaroo", 24));

		for (Animal2 animal : animals) {
			logger.trace(animal);
		};
	}
}
