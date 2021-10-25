package the_collections_framework;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;

public class Lecture25 {	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Lecture25.class);	 
	
	private static void example1() {
		ArrayList words = new ArrayList();
		words.add("hello");
		words.add("there");
		words.add(10);
		words.add(9);
		words.add(12.00);
		words.add('H');

		int item1 = (int) words.get(2);
		int item2 = (int) words.get(3);
		Integer sum = item1+item2;
		logger.trace(sum.toString());
	}
	
	private static void example2() {
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		words.add("10");


		String item1 = words.get(2);
		logger.trace(item1);
	}
	
	public static void run() {
		example1();
		example2();
	}

}
