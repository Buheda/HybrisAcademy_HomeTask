package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture40_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Logger;

import com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture40_BlockingQueue.producerconsumer.Consumer;
import com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture40_BlockingQueue.producerconsumer.Producer;
import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Application {
	
	final static int QUESTIONS_LIMIT = 5;

	
	public static void main(String[] args) throws InterruptedException {	
		BlockingQueue<Integer> questions = new ArrayBlockingQueue<Integer>(QUESTIONS_LIMIT);
		Logger logger = LoggerUtil.getLogger("Lecture40");

		Producer producer = new Producer(questions);
		Thread producerTask = new Thread(producer);
		
		Consumer consumer = new Consumer(questions);	
		Thread consumerTask = new Thread(consumer);

		consumerTask.start();
		producerTask.start();

	}

}
