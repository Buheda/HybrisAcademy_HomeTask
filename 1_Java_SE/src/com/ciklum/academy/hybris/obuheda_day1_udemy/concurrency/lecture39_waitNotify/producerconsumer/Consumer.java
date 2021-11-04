package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture39_waitNotify.producerconsumer;

import java.util.List;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Consumer implements Runnable{

	private List<Integer> questions = null;
	
	public Consumer(List<Integer> questions) {
		this.questions = questions;
	}
	
	public void answerQuestion() throws InterruptedException {
		synchronized (questions) {			
			while (questions.isEmpty()) {
				LoggerUtil.getLogger().trace("No questions to answer... waiting for questions");
				questions.wait();
			}
		}
		
		synchronized (questions) {	
			Thread.sleep(5000);
			LoggerUtil.getLogger().trace("ANSWER to Question: "+questions.remove(0));
			questions.notify();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				LoggerUtil.getLogger().error(e);		
			}	
		}
	}

}
