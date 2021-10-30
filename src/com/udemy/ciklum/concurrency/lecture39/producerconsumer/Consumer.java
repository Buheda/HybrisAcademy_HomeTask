package com.udemy.ciklum.concurrency.lecture39.producerconsumer;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Consumer implements Runnable{

	private Logger logger = LoggerUtil.getLogger(Consumer.class.getName());

	private List<Integer> questions = null;
	
	public Consumer(List<Integer> questions) {
		this.questions = questions;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void answerQuestion() throws InterruptedException {
		synchronized (questions) {			
			while (questions.isEmpty()) {
				logger.trace("No questions to answer... waiting for questions");
				questions.wait();
			}
		}
		
		synchronized (questions) {	
			Thread.sleep(5000);
			logger.trace("ANSWER to Question: "+questions.remove(0));
			questions.notify();
		}
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
