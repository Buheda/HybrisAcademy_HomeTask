package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture36_startThread;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class RunnableTask implements Runnable{
	
   private String threadName;
	
   RunnableTask (String name) {
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
