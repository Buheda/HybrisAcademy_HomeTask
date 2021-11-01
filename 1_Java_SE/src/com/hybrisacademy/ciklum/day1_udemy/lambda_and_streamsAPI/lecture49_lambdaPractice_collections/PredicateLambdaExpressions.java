package com.hybrisacademy.ciklum.day1_udemy.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.List;
import java.util.function.Predicate;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class PredicateLambdaExpressions {
		
	static void print(List<Car> cars) {
		LoggerUtil.getLogger().trace("\nPrint Lambda using predicat:");
		
		LoggerUtil.getLogger().trace("printCarsPriceRange:");
		genericPrintCars(cars, (c)-> {return (18000 <= c.getPrice() && c.getPrice() <= 22000);});

		LoggerUtil.getLogger().trace("printCarsByColor:");
		genericPrintCars(cars, (c)-> {return c.getColor().equals("Red");});
	}
	
	static void genericPrintCars(List<Car> cars, Predicate<Car> predicate) {
		for(Car c: cars) {
			if(predicate.test(c)) {
				c.printCar();
			}
		}
	}
}
