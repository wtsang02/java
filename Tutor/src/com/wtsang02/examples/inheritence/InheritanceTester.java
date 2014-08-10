package com.wtsang02.examples.inheritence;

public class InheritanceTester {

	public static void main(String[] args) {
		
		Manager m=new Manager();
		Salesman s=new Salesman();
		/*
		 * First create two objects, Notice in the output, "Employee is made"
		 * This is because when making a object that extends from base class,
		 * baseclass constructor will be called first.
		 * 
		 */
		
		
		double managerSalary = m.getManagerSalary();
		m.getPaided(managerSalary);
		
		double salesmanSalary=s.getSalesmanSalary();
		s.getPaided(salesmanSalary);
		 
		/*
		 * Conclusion
		 * Notice in s.getPaided(salesmanSalary); the output was " I am Employee..."
		 * This is because it was calling from the base class Employee, and giving
		 * its salesmanSalary in the parameters.
		 */
	}

}
