package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture35_intro;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = null;
	
	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture35");
		example1();
		example2();
		
		exampleException();
	}
	
	private static void example1() {
		logger.info("example1");
		logger.trace("Hi, there!");
		
		Task taskRunner = new Task("Number1:");
		taskRunner.start();
		for (int i = 0; i < 10; i++) {
			logger.trace("MainNumber: " + i);
		}		   
	}
	
	private static void exampleException() {
		logger.info("\nexampleException");
			
		Task taskRunner = new Task("NumberEx:");
		taskRunner.start();
		logger.trace("Hi, there!");
		try {
			taskRunner.start();
		} catch (IllegalThreadStateException e) {
			logger.error(e);
		}
	}
	
	private static void example2() {
		logger.info("\nexample2");
			
		Task taskRunner = new Task("Number2.1:");
		taskRunner.start();
		logger.trace("Hi, there!");
		Task taskRunner2 = new Task("Number2.2:");
		taskRunner2.start();
	}

}
