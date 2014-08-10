package com.wtsang02.examples.inheritence;

public class Salesman extends Employee {
	
	private double salesmanSalary;
	
	public Salesman(){
		setSalesmanSalary();
		/*
		 * First we prepare the salary for salesman.
		 */
		
	}
	
	public double getSalesmanSalary() {
		return salesmanSalary;
	}
	
	private void setSalesmanSalary() {
		salesmanSalary=getBaseSalary()*1.2;
		/*
		 * getBaseSalary is from the base class.This class
		 * inherits this method so it can be used. Since salesman gets
		 * more than base, we will * by 1.2
		 */
	}

	@Override
	public void getPaided(double salary) {
		super.getPaided(salary);
		/*
		 * This demostrats the super.method() keyword. In the output , it will print
		 * out the "I am a EMPLOYEE ... and get paid SALESMANSALARY" because
		 * we are taking the salary from this parameter.
		 */
	}
}
