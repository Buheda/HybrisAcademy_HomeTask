package com.udemy.ciklum.concurrency.lecture39_waitNotify.producerconsumer;

import java.util.List;

import com.udemy.ciklum.util.LoggerUtil;

public class Producer implements Runnable{
	
	final int QUESTIONS_LIMIT = 5;

	private List<Integer> questions = null;
	private int questionNo;
	
	public Producer(List<Integer> questions) {
		this.questions = questions;
	}

	public void readQuestion(int questionNo) throws InterruptedException {
		synchronized (questions) {			
			while (QUESTIONS_LIMIT == questions.size()) {
				LoggerUtil.getLogger().trace("questions have piled up... waiting for answers");
				questions.wait();
			}
		}
		
		synchronized (questions) {
			LoggerUtil.getLogger().trace("New Question: "+questionNo);
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
				LoggerUtil.getLogger().error(e);		
			}	
		}
	}

}
