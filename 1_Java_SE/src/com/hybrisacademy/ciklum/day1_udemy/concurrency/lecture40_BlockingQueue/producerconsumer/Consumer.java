package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture40_BlockingQueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Consumer implements Runnable{
	
	private BlockingQueue<Integer> questions = null;
	
	public Consumer(BlockingQueue<Integer> questions2) {
		this.questions = questions2;
	}
	
	public synchronized void answerQuestion() throws InterruptedException {
		Thread.sleep(1000);
		LoggerUtil.getLogger().trace("ANSWER to Question: "+questions.take());
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
