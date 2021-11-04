package com.ciklum.academy.hybris.obuheda_day1_udemy.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Car {
	private String make, model, color;
	private int price;
	
	public Car(String make, String model, String color, int price) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.price = price;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void printCar() {
		LoggerUtil.getLogger().trace(this);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", color=");
		builder.append(color);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
}
