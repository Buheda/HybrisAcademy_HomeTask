package com.udemy.ciklum.concurrency.lecture36_startThread;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Task extends Thread {
   
   @Override
   public void run() {
	   Logger logger = LoggerUtil.getLogger("Lecture36");
	   for (int i = 0; i < 10; i++) {
		   logger.trace(i + ",  defaultName="+Thread.currentThread().getName());
		   try {
			   Thread.sleep(10);
		   } catch (InterruptedException e) {
			   logger.trace(e);
		   }
	   }
   }
}
