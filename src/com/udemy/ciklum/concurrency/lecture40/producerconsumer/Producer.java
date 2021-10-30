package com.udemy.ciklum.concurrency.lecture40.producerconsumer;

import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Producer implements Runnable{
	private Logger logger = LoggerUtil.getLogger(Producer.class.getName());

	private BlockingQueue<Integer> questions = null;
	private int questionNo = 0;
	
	public Producer(BlockingQueue<Integer> question) {
		this.questions = question;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public synchronized void readQuestion() throws InterruptedException {		
		logger.trace("New Question: "+questionNo);
		questions.put(questionNo++);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				readQuestion();
			} catch (InterruptedException e) {
				logger.error(e);		
			}	
		}
	}

}
