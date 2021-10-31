package com.udemy.ciklum.lambda_and_streamsAPI.lecture49_lambdaPractice_collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("Lecture49");

	public static void main(String[] args) {
		List<Car> cars = Arrays.asList(
			new Car("Honda", "Accord", "Red", 22300),
			new Car("Honda", "Civic", "Blue", 17700),
			new Car("Toyota", "Land Cruiser", "White", 48500),
			new Car("Toyota", "Corolla", "Black", 16200),
			new Car("Toyota", "Camry", "Blue", 24000),
			new Car("Nissan", "Sentra", "White", 17300),
			new Car("Mitsubishi", "Lancer", "White", 20000),
			new Car("Jeep", "Wrangler", "Red", 24500)
		);
		
		UsualMethods.print(cars);
		NestedObjects.print(cars);
		LambdaExpressions.print(cars);
		GenericLambdaExpressions.print(cars);
		PredicateLambdaExpressions.print(cars);
		
		LoggerUtil.getLogger().trace("\n`Using Function:");

		
		Function<Car, String> priceAndColor = (c) -> {
			return "price= "+c.getPrice() + " color ="+c.getColor();
		};
		LoggerUtil.getLogger().trace(priceAndColor.apply(cars.get(0)));
	}
	
	
	

}
