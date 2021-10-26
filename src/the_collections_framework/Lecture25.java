package the_collections_framework;

import java.util.ArrayList;
import java.util.LinkedList;

import org.slf4j.LoggerFactory;


public class Lecture25 {	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Lecture25.class);	 
	
	private static void example1() {
		logger.info("example1");
		
		ArrayList words = new ArrayList();
		words.add("hello");
		words.add("there");
		words.add(10);
		words.add(9);
		words.add(12.00);
		words.add('H');

		int item1 = (int) words.get(2);
		int item2 = (int) words.get(3);
		logger.trace("{}", item1+item2);
	}
	
	private static void example2() {
		logger.info("example2");
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		words.add("10");

		String item1 = words.get(2);
		logger.trace(item1);
	}
	
	private static void example3() {
		logger.info("example3");
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(100);
		numbers.add(200);
		numbers.add(45);
		numbers.add(1000);

		for (Integer number: numbers) {
			logger.trace("{}", number);
		}
	}
	
	private static void example4() {
		logger.info("example4");
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(100);
		numbers.add(200);
		numbers.add(45);
		numbers.add(1000);
		
		numbers.remove(2);
		
		for (Integer number: numbers) {
			logger.trace("{}", number);
		}
	}
	
	private static void example5() {
		logger.info("example5");
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(100);
		numbers.add(200);
		numbers.add(45);
		numbers.add(1000);
		
		//numbers.remove();
		numbers.removeFirst();
		
		for (Integer number: numbers) {
			logger.trace("{}", number);
		}
	}
	
	public static void run() {
		example1();
		example2();
		example3();
		example4();
		example5();

	}

}
