package com.udemy.ciklum.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.List;

import com.udemy.ciklum.util.LoggerUtil;



public class LambdaExpressions {
	
	@FunctionalInterface 
	interface CarCondition {
		public boolean test(Car c);
	}
	
	private static void printCars(List<Car> cars, CarCondition condition) {
		for(Car c: cars) {
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}
	
	public static void print(List<Car> cars) {
		LoggerUtil.getLogger().trace("\nPrint LambdaExpressions:");
		
		LoggerUtil.getLogger().trace("printCarsPriceRange:");
		printCars(cars, (c)-> {return (18000 <= c.getPrice() && c.getPrice() <= 22000);});

		LoggerUtil.getLogger().trace("printCarsByColor:");
		printCars(cars, (c)-> {return c.getColor().equals("Red");});
	}
	
}
