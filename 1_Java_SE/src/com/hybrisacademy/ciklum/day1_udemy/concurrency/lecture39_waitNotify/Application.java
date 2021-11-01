package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture39_waitNotify;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture39_waitNotify.producerconsumer.Consumer;
import com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture39_waitNotify.producerconsumer.Producer;
import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

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
