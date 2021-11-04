package com.ciklum.academy.hybris.obuheda_day1_udemy.concurrency.lecture38_CopyOnWriteArrayList.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;


public class InventoryManager_CopyOnWrite {
	private List<Product> soldProductList = new CopyOnWriteArrayList<Product>();
	private List<Product> purchasedProductList = new ArrayList<Product>();
	
	public void popuplateSoldProducts() {
		for (int i = 0; i < 1000; i++) {
			Product product = new Product(i, "test_product_"+i);
			soldProductList.add(product);
			LoggerUtil.getLogger().trace(Thread.currentThread().getName()+" ADDED:"+product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				LoggerUtil.getLogger().trace(e);
			}
		}
	}
	
	public void dislpaySoldProducts() {
		for (Product product : soldProductList) {
			LoggerUtil.getLogger().trace(Thread.currentThread().getName()+" SOLD PRODUCT:"+product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				LoggerUtil.getLogger().trace(e);
			}
		}
	}


}
