package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture36_startThread;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Task extends Thread {
   
   @Override
   public void run() {
	   for (int i = 0; i < 10; i++) {
		   LoggerUtil.getLogger().trace(i + ",  defaultName="+Thread.currentThread().getName());
		   try {
			   Thread.sleep(10);
		   } catch (InterruptedException e) {
			   LoggerUtil.getLogger().trace(e);
		   }
	   }
   }
}
