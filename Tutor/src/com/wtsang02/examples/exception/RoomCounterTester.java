package com.wtsang02.examples.exception;
public class RoomCounterTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RoomCounter rc = new RoomCounter();
		System.out.println();
		rc.addPerson();
		System.out.println("Current: " + rc.getCounter());
		rc.addPerson();
		System.out.println("Current: " + rc.getCounter());
		rc.addPerson();
		System.out.println("Current: " + rc.getCounter());
		
		rc.removePerson();
		System.out.println("Current: " + rc.getCounter());
		rc.removePerson();
		System.out.println("Current: " + rc.getCounter());
		rc.removePerson();
		System.out.println("Current: " + rc.getCounter());
		rc.removePerson();
		System.out.println("Current: " + rc.getCounter());
	}

}
