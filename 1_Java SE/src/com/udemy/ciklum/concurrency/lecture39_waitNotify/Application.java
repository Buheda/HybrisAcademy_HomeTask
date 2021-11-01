package com.udemy.ciklum.concurrency.lecture39_waitNotify;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.concurrency.lecture39_waitNotify.producerconsumer.Consumer;
import com.udemy.ciklum.concurrency.lecture39_waitNotify.producerconsumer.Producer;
import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		List<Integer> questions = new ArrayList<Integer>();
		Logger logger = LoggerUtil.getLogger("Lecture39");

		Producer producer = new Producer(questions);
		Thread producerTask = new Thread(producer);
		
		Consumer consumer = new Consumer(questions);	
		Thread consumerTask = new Thread(consumer);
		
		consumerTask.start();
		producerTask.start();

	}

}
