package com.udemy.ciklum.concurrency.lecture40;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.concurrency.lecture40.producerconsumer.Consumer;
import com.udemy.ciklum.concurrency.lecture40.producerconsumer.Producer;
import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	
	final static int QUESTIONS_LIMIT = 5;

	
	public static void main(String[] args) throws InterruptedException {	
		BlockingQueue<Integer> questions = new ArrayBlockingQueue<Integer>(QUESTIONS_LIMIT);
		Logger logger = LoggerUtil.getLogger("Lecture40");

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
