package com.udemy.ciklum.concurrency.lecture39;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.concurrency.lecture39.producerconsumer.Consumer;
import com.udemy.ciklum.concurrency.lecture39.producerconsumer.Producer;
import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		List<Integer> questions = new ArrayList<Integer>();
		Logger logger = LoggerUtil.getLogger("Lecture39");

		Producer producer = new Producer(questions);
		producer.setLogger(logger);
		Thread producerTask = new Thread(producer);
		
		Consumer consumer = new Consumer(questions);	
		consumer.setLogger(logger);
		Thread consumerTask = new Thread(consumer);
		
		consumerTask.start();
		producerTask.start();

	}

}
