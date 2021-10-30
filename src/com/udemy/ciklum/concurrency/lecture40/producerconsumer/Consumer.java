package com.udemy.ciklum.concurrency.lecture40.producerconsumer;

import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Consumer implements Runnable{
	private Logger logger = LoggerUtil.getLogger(Consumer.class.getName());

	private BlockingQueue<Integer> questions = null;
	
	public Consumer(BlockingQueue<Integer> questions2) {
		this.questions = questions2;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public synchronized void answerQuestion() throws InterruptedException {
		Thread.sleep(1000);
		logger.trace("ANSWER to Question: "+questions.take());
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				logger.error(e);		
			}	
		}
	}

}
