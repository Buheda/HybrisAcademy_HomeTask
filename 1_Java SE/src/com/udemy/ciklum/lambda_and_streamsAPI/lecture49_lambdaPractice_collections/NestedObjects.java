package com.udemy.ciklum.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.List;

import com.udemy.ciklum.util.LoggerUtil;

public class NestedObjects {
	
	@FunctionalInterface 
	interface CarCondition {
		public boolean test(Car c);
	}
	
	static void printCars(List<Car> cars, CarCondition condition) {
		for(Car c: cars) {
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}
	
	public static void print(List<Car> cars) {
		LoggerUtil.getLogger().trace("\nprint nestedObjects:");
		
		LoggerUtil.getLogger().trace("printCarsPriceRange:");
		printCars(cars, new CarCondition() {
			@Override
			public boolean test(Car c) {
				return (18000 <= c.getPrice() && c.getPrice() <= 22000);
			};
		});
		
		LoggerUtil.getLogger().trace("printCarsByColor:");
		printCars(cars, new CarCondition() {
			@Override
			public boolean test(Car c) {
				return c.getColor().equals("Red");
			};
		});
	}
}