package com.udemy.ciklum.concurrency.lecture38.client;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.concurrency.lecture38.inventory.InventoryManager;
import com.udemy.ciklum.util.LoggerUtil;

public class Application1 {
	private static Logger logger = LoggerUtil.getLogger("Lecture38_example1");
	
	public static void main(String[] args) throws InterruptedException {
		InventoryManager manager = new InventoryManager();		
		manager.setLogger(logger);

		Thread inventoryTask = new Thread(new Runnable() {
			public void run() {
				try {
					manager.popuplateSoldProducts();
				}catch (Exception e) {
					logger.error(e);
				}
			}
		});
			
		Thread displayTask = new Thread(new Runnable() {
			public void run() {
				try {
					manager.dislpaySoldProducts();
				}
				catch (Exception e) {
					logger.error(e);
				}
			}
		});

		inventoryTask.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.trace(e);
		};
		displayTask.start();
	}

}
