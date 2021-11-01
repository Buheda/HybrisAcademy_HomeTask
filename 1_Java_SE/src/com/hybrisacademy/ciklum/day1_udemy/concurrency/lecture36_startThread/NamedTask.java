package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture36_startThread;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class NamedTask extends Thread {

   private String threadName;
	
   NamedTask (String name) {
	   this.threadName = name;
   }
   
   @Override
   public void run() {
	   Thread.currentThread().setName(threadName);
	   
	   for (int i = 0; i < 10; i++) {
		   LoggerUtil.getLogger().trace(i + ", "+Thread.currentThread().getName());
		   try {
			   Thread.sleep(10);
		   } catch (InterruptedException e) {
			   LoggerUtil.getLogger().trace(e);
		   }
	   }
   }
}
