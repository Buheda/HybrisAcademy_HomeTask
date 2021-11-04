package com.ciklum.academy.hybris.obuheda_day1_udemy.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.List;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class GenericLambdaExpressions {
	
	@FunctionalInterface
	interface GenericCondition<T> {
		public boolean test(T t);
	}
	
	static void print(List<Car> cars) {
		LoggerUtil.getLogger().trace("\nPrint Lambda with generic FI:");
		
		LoggerUtil.getLogger().trace("printCarsPriceRange:");
		genericPrintCars(cars, (c)-> {return (18000 <= c.getPrice() && c.getPrice() <= 22000);});

		LoggerUtil.getLogger().trace("printCarsByColor:");
		genericPrintCars(cars, (c)-> {return c.getColor().equals("Red");});
	}
	
	static void genericPrintCars(List<Car> cars, GenericCondition<Car> condition) {
		for(Car c: cars) {
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}
}
