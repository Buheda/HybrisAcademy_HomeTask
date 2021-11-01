package com.hybrisacademy.ciklum.day1_udemy.concurrency.lecture38_CopyOnWriteArrayList.inventory;

public class Product {
	private int id;
	private String name;
	
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id: ");
		builder.append(id);
		builder.append(" | name: ");
		builder.append(name);
		return builder.toString();
	}
	
	
}
