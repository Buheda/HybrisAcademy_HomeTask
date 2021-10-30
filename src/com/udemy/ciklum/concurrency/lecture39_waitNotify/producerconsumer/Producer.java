package com.udemy.ciklum.concurrency.lecture39_waitNotify.producerconsumer;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Producer implements Runnable{
	final int QUESTIONS_LIMIT = 5;
	private Logger logger = LoggerUtil.getLogger(Producer.class.getName());

	private List<Integer> questions = null;
	private int questionNo;
	
	public Producer(List<Integer> questions) {
		this.questions = questions;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void readQuestion(int questionNo) throws InterruptedException {
		synchronized (questions) {			
			while (QUESTIONS_LIMIT == questions.size()) {
				logger.trace("questions have piled up... waiting for answers");
				questions.wait();
			}
		}
		
		synchronized (questions) {			
			logger.trace("New Question: "+questionNo);
			questions.add(questionNo);
			Thread.sleep(100);
			questions.notify();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				readQuestion(questionNo++);
			} catch (InterruptedException e) {
				logger.error(e);		
			}	
		}
	}

}
