package com.udemy.ciklum.concurrency.lecture38.inventory;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;


public class InventoryManager {
	private List<Product> soldProductList = new ArrayList<Product>();
	private List<Product> purchasedProductList = new ArrayList<Product>();
	private Logger logger = null;
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void popuplateSoldProducts() {
		for (int i = 0; i < 1000; i++) {
			Product product = new Product(i, "test_product_"+i);
			soldProductList.add(product);
			logger.trace(Thread.currentThread().getName()+" ADDED:"+product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				logger.trace(e);
			}
		}
	}
	
	public void dislpaySoldProducts() {
		for (Product product : soldProductList) {
			logger.trace(Thread.currentThread().getName()+" SOLD PRODUCT:"+product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				logger.trace(e);
			}
		}
	}


}
