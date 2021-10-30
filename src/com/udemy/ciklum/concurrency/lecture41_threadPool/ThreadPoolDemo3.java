package com.udemy.ciklum.concurrency.lecture41_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class ThreadPoolDemo3 {

	private static Logger logger = LoggerUtil.getLogger("Lecture41_3");
	
	public static void main(String[] args) {
		logger.info("shutdownNow:");

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable processor1 = new MessageProcessor(10);
		executor.execute(processor1);
		
		Runnable processor2 = new MessageProcessor(20);
		executor.execute(processor2);
		
		Runnable processor3 = new MessageProcessor(30);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(40);
		executor.execute(processor4);
		
		Runnable processor5 = new MessageProcessor(50);
		executor.execute(processor5);
		
		executor.shutdownNow();
		
		while(!executor.isTerminated()) {}
		
		logger.trace("processed all tasks");
	}

}
