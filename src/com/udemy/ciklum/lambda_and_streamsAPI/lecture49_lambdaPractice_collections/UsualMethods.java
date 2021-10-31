package com.udemy.ciklum.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.List;

import com.udemy.ciklum.util.LoggerUtil;

public class UsualMethods {
	
	public static void print(List<Car> cars) {
		LoggerUtil.getLogger().trace("\nPrint usual methods:");
		printCarsPriceRange(cars, 18000, 22000);
		printCarsByColor(cars, "Red");
	}
	
	static void printCarsPriceRange(List<Car> cars, int low, int high) {
		LoggerUtil.getLogger().trace("printCarsPriceRange:");
		for(Car c: cars) {
			if(low <= c.getPrice() && c.getPrice() <= high) {
				c.printCar();
			}
		}
	}

	static void printCarsByColor(List<Car> cars, String color) {
		LoggerUtil.getLogger().trace("printCarsByColor:");
		for(Car c: cars) {
			if(c.getColor().equals(color)) {
				c.printCar();
			}
		}
	}
}
