package com.wtsang02.examples.inheritence;

public class Manager extends Employee{
	private double managerSalary;
	
	public Manager(){
		setManagerSalary();
		/*
		 * First we prepare the salary for Manager.
		 */
	}

	public double getManagerSalary() {
		return managerSalary;
	}


	
	private void setManagerSalary() {
		managerSalary=getBaseSalary()*1.5;
		/*
		 * getBaseSalary is from the base class. This class
		 * inherits this method so it can be used. Since manager gets
		 * more than base, we will * by 1.5
		 */
	}

	@Override
	public void getPaided(double salary) {
		System.out.println("I am a manager , I got paid "+salary);
	}


	
	
	
	

	
	
	
}
