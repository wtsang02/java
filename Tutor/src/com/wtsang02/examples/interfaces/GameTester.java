package com.wtsang02.examples.interfaces;

public class GameTester {

	public static void main(String[] args) {

		Devil d = new Devil();
		Witch w = new Witch();
		Orc o = new Orc();
		
		// create three speific monsters.

		Attackable[] attackArray = { d, w, o };
		
		/*
		 * Remember Arrays can only hold one data type? NOtice this is a
		 * attackable array that holds Devil, witch, orc. This is OK because all
		 * subclasses implements the Attackable interface.
		 */

		for (int i = 0; i < attackArray.length; i++) {
			attackArray[i].attack();
		}
		System.out.println(Attackable.height);
		/*
		 * Just looping through the array and calling the attack() for each
		 * monster in the array.
		 */
	}
	/*
	 * Run this, and Conclusions: 1) lets say we didn't have something called
	 * interfaces, you would be having to call .attack() on each speifc monster,
	 * 3 is easy, but what if you have 3000? 2) Also notice that attackArray
	 * data type is Attackable, and each element calls its own .attack() method,
	 * the JVM is smart enough to do that.
	 */

}
