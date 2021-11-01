package com.udemy.ciklum.concurrency.lecture40_BlockingQueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

import com.udemy.ciklum.util.LoggerUtil;

public class Producer implements Runnable{
	
	private BlockingQueue<Integer> questions = null;
	private int questionNo = 0;
	
	public Producer(BlockingQueue<Integer> question) {
		this.questions = question;
	}
	
	public synchronized void readQuestion() throws InterruptedException {
		LoggerUtil.getLogger().trace("New Question: "+questionNo);
		questions.put(questionNo++);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				readQuestion();
			} catch (InterruptedException e) {
				LoggerUtil.getLogger().error(e);		
			}	
		}
	}

}
