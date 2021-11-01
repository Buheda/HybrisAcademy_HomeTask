package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture35_intro;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Task extends Thread {

   private String msg = "Number: ";
	
   Task (String msg) {
	   this.msg = msg;
   }
   
   @Override
   public void run() {   
	   for (int i = 0; i < 10; i++) {
		   LoggerUtil.getLogger().trace(msg +" " + i);
	   }
   }
}
