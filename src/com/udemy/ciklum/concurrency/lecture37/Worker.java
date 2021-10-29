package com.udemy.ciklum.concurrency.lecture37;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Worker  extends Thread {
	Sequence sequence = null;
	
	public Worker(Sequence sequnce) {
		this.sequence = sequnce;
	}
	
	 @Override
	   public void run() {
		   Logger logger = LoggerUtil.getLogger("Lecture37");
		   for (int i = 0; i < 50; i++) {
				logger.trace(Thread.currentThread().getName() +": "+ sequence.getNext());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					logger.trace(e);
				}
			}
	   }
}
