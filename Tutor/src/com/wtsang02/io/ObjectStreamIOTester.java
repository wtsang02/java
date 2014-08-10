package com.wtsang02.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.wtsang02.examples.inheritence.Employee;

public class ObjectStreamIOTester {
/*
Lab Excercise:
Text file "grade.txt" contains 10 students grade. Each line with one grade.
-Read all grrades from the file "grade.txt" and write them as integers into a binary file (binaryGrade.dat).
-Read grades from the binary file "binaryGrade.dat" and compute the average grade.
 */

	public static void main(String[] args) {

		int NUMBER_OF_GRADES=10;
		//constants
		
		
		ObjectStreamIO io=new ObjectStreamIO();
		//create object and an array.

		File sourceFile=io.generateGrades(NUMBER_OF_GRADES);
		//generateGrades() will return a File  with  random grades in it.
		
		String[] dataRead=new String[NUMBER_OF_GRADES];
		try {
			dataRead = io.readLineFromFile(sourceFile, NUMBER_OF_GRADES);
			//Reads every line of the file and returns as String[]
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File binaryFile=new File(io.getNameOfBinGradeFile());
		//create binaryFile, getting the name from io object.
		
		ObjectOutputStream output = null;             
		try{
		output=new ObjectOutputStream(new FileOutputStream(binaryFile));
		output.writeObject(dataRead);//writes the data
		output.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	
	

		String[] binaryDataBack=new String[NUMBER_OF_GRADES];
		ObjectInputStream input = null;
		try{
			
			
			input=new ObjectInputStream(new FileInputStream(binaryFile));
			binaryDataBack=(String[])input.readObject();//reads the data
			input.close();
			
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//getSum(String[]) <-- this method will convert it back to int as well.
		System.out.println("Avg is: "+io.getAverage(binaryDataBack));
		

	}

}
