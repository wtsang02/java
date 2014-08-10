package com.wtsang02.recursion;

public class CountUppercase {

	public static void main(String[] args) {
		System.out.println(countUppercaseLetter("HAHahahaHAHA"));

	}
	//This method only executes once.
	public static int countUppercaseLetter(String s) {
		
		return countUppercaseLetter(s, 0, s.length() - 1);
	}

	//This method will execute the amount of times it needed to fulfill the 
	//first if statement.
	public static int countUppercaseLetter(String s, int low, int high) {
		if (low <= high) {//THIS is the condition for the program to loop.
			if (Character.isUpperCase(s.charAt(low))) {
				//this letter is uppercase, so add 1.
				return 1 + countUppercaseLetter(s, low + 1, high);
			} else {
				//this letter is NOT uppercase, continue.
				return 0+ countUppercaseLetter(s, low + 1, high);
			}
		} else {
			return 0;//Finishes
		}

	}



}
