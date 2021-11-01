package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture36_startThread;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = null;
	
	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture36");
		example1();
		example2();
		example3();
		example4();
	}
	
	private static void example1() {
		logger.info("example1");
		
		logger.info("Thread1");
		Task taskRunner = new Task();
		taskRunner.start();
		logger.info("Thread2");
		Task taskRunner2 = new Task();
		taskRunner2.start();  
	}
	
	private static void example2() {
		logger.info("\nexample2");
		
		logger.info("NamedThread1");
		NamedTask taskRunner = new NamedTask("Thread1");
		taskRunner.start();
		logger.info("NamedThread2");
		NamedTask taskRunner2 = new NamedTask("Thread2");
		taskRunner2.start();  
	}

	private static void example3() {
		logger.info("\nexample3");
		
		RunnableTask taskRunner = new RunnableTask("Thread3");
		taskRunner.run();
	}
	
	private static void example4() {
		logger.info("\nexample4");
		
		RunnableTask taskRunner = new RunnableTask("Thread4");
		taskRunner.run();
		Thread t1=new Thread(taskRunner);
		t1.start();
		
		RunnableTask taskRunner2 = new RunnableTask("Thread5");
		taskRunner2.run();
		Thread t2=new Thread(taskRunner2);
		t2.start();
	}
}
