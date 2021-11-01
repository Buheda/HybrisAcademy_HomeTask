package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture37_synchronization;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = null;
	
	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture37");
		example1();
		example2();
		
	}
	
	private static void example1() {
		logger.info("example1");
		
		Sequence sequence = new Sequence();
		for (int i = 0; i < 100; i++) {
			logger.trace(sequence.getNext());
			
		}
	}
	
	private static void example2() {
		logger.info("\nexample2");
		
		Sequence sequence = new Sequence();
		
		Worker worker1 = new Worker(sequence);
		worker1.start();
		Worker worker2 = new Worker(sequence);
		worker2.start();  
	}

}
