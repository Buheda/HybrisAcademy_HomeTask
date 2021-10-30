package com.udemy.ciklum.concurrency.lecture38_CopyOnWriteArrayList.client;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.concurrency.lecture38_CopyOnWriteArrayList.inventory.InventoryManager;
import com.udemy.ciklum.util.LoggerUtil;

public class Application2 {
	private static Logger logger = LoggerUtil.getLogger("Lecture38_example2");
	
	public static void main(String[] args) throws InterruptedException {
		InventoryManager manager = new InventoryManager();		
		
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
		inventoryTask.join();

		displayTask.start();
	}
}
