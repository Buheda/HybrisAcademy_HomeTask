package the_collections_framework.lecture26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import util.LoggerUtil;

public class Application {
	private static Logger logger = null;

	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture26");
		example1();
		example2();
		example3();
		example4();
		example5();
	}
	
	private static void example1() {
		logger.info("example1");
		List<String> animals = new ArrayList<String>();
		animals.add("Lion");
		animals.add("cat");
		animals.add("Dog");
		animals.add("Bird");
		for (int i = 0; i < animals.size(); i++) {
			logger.trace(animals.get(i));
		}
		
		for (String animal : animals) {
			logger.trace(animal);
		};
	}
	
	private static void example2() {
		logger.info("\nexample2");
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle toyota = new Vehicle("Toyota", "Camry", 12000, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 12000, false));
		vehicles.add(toyota);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		for (Vehicle car : vehicles) {
			logger.trace("{}\n{}\n{}\n",car.getMake(), car.getModel(), car.getPrice());
		}
	}
	
	private static void example3() {
		logger.info("\nexample3-ArrayList & toString");
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle toyota = new Vehicle("Toyota", "Camry", 12000, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 12000, false));
		vehicles.add(toyota);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		for (Vehicle car : vehicles) {
			logger.trace(car);
		}
	}
	
	private static void example4() {
		logger.info("\nexample4-linkedList");
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		Vehicle toyota = new Vehicle("Toyota", "Camry", 12000, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 12000, false));
		vehicles.add(toyota);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		for (Vehicle car : vehicles) {
			logger.trace(car);
		}
	}
	
	private static void example5() {
		logger.info("\nexample5-printElements");
		List<String> animals = new ArrayList<String>();
		animals.add("Lion");
		animals.add("cat");
		animals.add("Dog");
		animals.add("Bird");
		
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		Vehicle toyota = new Vehicle("Toyota", "Camry", 12000, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 12000, false));
		vehicles.add(toyota);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		printElements(vehicles);
		printElements(animals);

	}
	
	public static void printElements(List someList) {
		for (int i = 0; i < someList.size(); i++) {
			logger.trace(someList.get(i));
		}
	}
	


}
