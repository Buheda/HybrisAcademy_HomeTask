package com.udemy.ciklum.concurrency.lecture41;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class MessageProcessor implements Runnable {
	private static Logger logger = LoggerUtil.getLogger("Lecture41");

	private int message;

	public MessageProcessor(int message) {
		this.message = message;
	}
	
	public static void setLogger(Logger logger) {
		MessageProcessor.logger = logger;
	}
		
	@Override
	public void run() {
		logger.trace(Thread.currentThread().getName() + "[RECEIVED] Message = " + message);
		responseToMessage();
		logger.trace(Thread.currentThread().getName() + "(DONE) Processing Message = " + message);
	}

	private void responseToMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error("Unable to process message {} cause: {}", message, e);		
		}	
	}
	
}
