package com.wtsang02.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadTextGradeTester {

	public static void main(String[] args) {
		// Make your own StudentGrades.txt with the given format first.
		File sourceFile = new File("StudentGrades.txt");
		
		//Scanner to read your file
		Scanner in = null;
		try {
			in = new Scanner(sourceFile);//refer it to your source file.
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// You can use array, arrayList, but lets use LinkedList for practice.
		LinkedList<String> names = new LinkedList<String>();
		LinkedList<Integer> grades; //declare this. because we need a new one for each line.
		String name = null;
		int counter =0;
		while (in.hasNext()) {
			grades= new LinkedList<Integer>();//reset the list for each line
			name = in.next() + " " + in.next();//retrive first and last name.
			names.add(name);
			while (in.hasNextInt()) {//retrive all the grades after the 'firstLastName,'

				int grade = in.nextInt();
				grades.add(grade);//add each grade in the list.

			}
			double avg = calcAvg(grades);//pass in the list for the method to get the avg.
			System.out.println(names.get(counter)+ avg);
			
			counter++;
		}

	}

	public static double calcAvg(LinkedList<Integer> grades) {
		int sum = 0;
		int i=0;//declare it here , so we know total size later.
		for ( i= 0; i < grades.size(); i++) {
			sum += grades.get(i);//add to the sum.
		}
		
		return (double)sum/i;//avg, cast to double first before you divide to get decimals.
		//if you don't want to cast, it can remain as an integer. Your choice.

	}
}
