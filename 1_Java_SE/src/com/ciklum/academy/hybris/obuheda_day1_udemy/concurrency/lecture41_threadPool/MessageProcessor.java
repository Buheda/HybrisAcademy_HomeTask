package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture41_threadPool;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class MessageProcessor implements Runnable {
	
	private int message;

	public MessageProcessor(int message) {
		this.message = message;
	}
			
	@Override
	public void run() {
		LoggerUtil.getLogger().trace(Thread.currentThread().getName() + "[RECEIVED] Message = " + message);
		responseToMessage();
		LoggerUtil.getLogger().trace(Thread.currentThread().getName() + "(DONE) Processing Message = " + message);
	}

	private void responseToMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			LoggerUtil.getLogger().error("Unable to process message {} cause: {}", message, e);		
		}	
	}
	
}
