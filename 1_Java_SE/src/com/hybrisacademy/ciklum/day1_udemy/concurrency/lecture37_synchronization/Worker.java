package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture37_synchronization;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Worker  extends Thread {
	Sequence sequence = null;
	
	public Worker(Sequence sequnce) {
		this.sequence = sequnce;
	}
	
	 @Override
	   public void run() {
		   for (int i = 0; i < 50; i++) {
			    LoggerUtil.getLogger().trace(Thread.currentThread().getName() +": "+ sequence.getNext());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					LoggerUtil.getLogger().trace(e);
				}
			}
	   }
}