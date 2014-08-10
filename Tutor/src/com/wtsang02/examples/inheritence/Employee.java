package com.wtsang02.examples.inheritence;

public class Employee {
	
	public static double baseSalary = 10000.0;
	
	public Employee() {
		System.out.println("Employee is made");
		/*
		 * This is constructor and is called when any Employee 
		 * is created.
		 */
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void getPaided(double salary) {
		System.out.println("I am Employee,I got paid: " + salary);
	}
}
