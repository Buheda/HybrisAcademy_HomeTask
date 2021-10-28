package com.udemy.ciklum.the_collections_framework.lecture28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	private static Logger logger = null;

	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture28");
		example1();
		example2();
		example3();
		example4();
	}
	
	private static void example1() {
		logger.info("example1 - List methods");
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(12);
		list1.add(43);
		list1.add(15);
		list1.add(67);
		list1.add(43);
		list1.add(10);
		list1.add(10);
		list1.add(10);
		list1.add(10);
		

		List<Integer> newList = new ArrayList<Integer>();
		newList.add(10);
		newList.add(15);
		newList.add(67);
		
		logger.trace("List1: "+list1);

		list1.addAll(newList);
		List<Integer> list1copy = new ArrayList<Integer>(list1);

		logger.trace("merged list1: "+list1); 
		
		logger.trace("newList: "+newList);

		logger.trace("Contains 67: "+ list1.contains(67));
		logger.trace("Contains 48: "+list1.contains(48));
		logger.trace("list1.isEmpty: "+list1.isEmpty());
		logger.trace("retain list1(newList): "+list1.retainAll(newList)+", "+list1);

		logger.trace("removeAll list1(newList): "+list1copy.removeAll(newList)+", "+list1copy);
		
		list1.clear();
		logger.trace("list1 after clear: "+list1);
		
		logger.trace("list1.isEmpty: "+list1.isEmpty());
	}
	
	private static void example2() {
		logger.info("\nexample2 - HashSet<Integer> to List and sort");
		Set<Integer> set = new HashSet<Integer>();
		set.add(12);
		set.add(43);
		set.add(15);
		set.add(67);
		set.add(43);
		set.add(10);
		set.add(10);
		set.add(10);
		set.add(10);
		
		logger.trace(set);
		
		List<Integer> list = new ArrayList<Integer>(set);
		
		logger.trace(list);
		Collections.sort(list);
		logger.trace(list);
	}
	
	private static void example3() {
		logger.info("\nexample3 - HashSet<String> to List and sort");
		Set<String> set = new HashSet<String>();
		set.add("Random");
		set.add("People");
		set.add("Animal");
		set.add("Zoo");
		set.add("Car");
		
		logger.trace(set);
		
		List<String> list = new ArrayList<String>(set);
		
		logger.trace(list);
		Collections.sort(list);
		logger.trace(list);
	}
	
	private static void example4() {
		logger.info("\nexample4 - HashSet<Employee> to List and sort");
		Set<Employee> set = new HashSet<Employee>();
		set.add(new Employee("Mike", 3500, "Accounting"));
		set.add(new Employee("Paul", 3000, "DevOps"));
		set.add(new Employee("Peter", 2500, "Developer"));
		set.add(new Employee("Angel", 2000, "HR"));

		
		logger.trace(set);
		
		List<Employee> list = new ArrayList<Employee>(set);
		
		logger.trace(list);
		Collections.sort(list);
		logger.trace(list);
	}
}
