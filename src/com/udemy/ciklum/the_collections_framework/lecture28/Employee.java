package com.udemy.ciklum.the_collections_framework.lecture28;

public class Employee implements Comparable<Employee> {
	private String name;
	private int salary;
	private String department;
	
	
	public Employee(String name, int salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", department=");
		builder.append(department);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int compareTo(Employee o) {
		if (o.salary < salary)
			return 1;
		else if (o.salary > salary)
			return -1;
		else 
			return 0; 
	}
	
}
