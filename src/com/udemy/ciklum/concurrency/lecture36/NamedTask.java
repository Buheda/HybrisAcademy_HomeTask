package com.udemy.ciklum.concurrency.lecture36;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class NamedTask extends Thread {

   private String threadName;
	
   NamedTask (String name) {
	   this.threadName = name;
   }
   
   @Override
   public void run() {
	   Logger logger = LoggerUtil.getLogger("Lecture35");
	   Thread.currentThread().setName(threadName);
	   
	   for (int i = 0; i < 10; i++) {
		   logger.trace(i + ", "+Thread.currentThread().getName());
		   try {
			   Thread.sleep(10);
		   } catch (InterruptedException e) {
			   logger.trace(e);
		   }
	   }
   }
}
