package com.udemy.ciklum.concurrency.lecture35;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Task extends Thread {

   private String msg = "Number: ";
	
   Task (String msg) {
	   this.msg = msg;
   }
   
   @Override
   public void run() {
	   Logger logger = LoggerUtil.getLogger("Lecture35");
	   
	   for (int i = 0; i < 10; i++) {
		   logger.trace(msg +" " + i);
	   }
   }
}
