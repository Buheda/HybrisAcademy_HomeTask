package com.hybrisacademy.ciklum.day1_udemy.lambda_and_streamsAPI.lecture47_lambdaIntro;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("Lecture47");
	
	public static void main(String[] args) {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
	}
	
	static void humanWalker(Human human) {
		human.walk();
	}
	
	static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}
	
	static void example1() {
		logger.info("example1 - walk");
		Human tom = new Human();
		tom.walk();
		
		Robot walley = new Robot();
		walley.walk();
	}
	
	static void example2() {
		logger.info("\nexample2 - humanWalker");
		Human tom = new Human();
		humanWalker(tom);
		
		Robot walley = new Robot();
		walley.walk();
	}
	
	static void example3() {
		logger.info("\nexample3 - polymorphism");
		Human tom = new Human();
		walker(tom);
		
		Robot walley = new Robot();
		walker(walley);
	}
	
	static void example4() {
		logger.info("\nexample4 - nested object");
		
		walker(new Walkable() {
			@Override
			public void walk() {
				LoggerUtil.getLogger().trace("Custom object walking");
			}
		});
	}
	
	static void example5() {
		logger.info("\nexample5 - lambda");
		
		walker( () -> {
			LoggerUtil.getLogger().trace("Custom object walking");
		});
	}
	
	static void example6() {
		logger.info("\nexample6 - assign and pass");
		
		Walkable lambdaWalker = () -> {
			LoggerUtil.getLogger().trace("Custom object walking");
		};
		
		lambdaWalker.walk();
		walker(lambdaWalker);
		
	}
}
