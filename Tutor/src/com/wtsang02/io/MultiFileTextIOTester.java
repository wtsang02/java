package com.wtsang02.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultiFileTextIOTester {

	public static void main(String[] args) {
		//Create helper object;
		FileTextIOMin helper = new FileTextIOMin();
		//Create gradeFile from userinput.
		File file1 = helper.createGradeFileFromUser("grade1.txt");
		//Get their grades as an int array.
		int[] file1Grades=helper.getGrades();
		File file2 = helper.createGradeFileFromUser("grade2.txt");
		int[] file2Grades=helper.getGrades();
		File file3 = helper.createGradeFileFromUser("grade3.txt");
		int[] file3Grades=helper.getGrades();
		
		//Declaring variables for file data;
		String[] dataFromFile1=null;
		String[] dataFromFile2=null;
		String[] dataFromFile3=null;
		
		try {
			/*
			 * Reads each line in file of the 1st params, 
			 * and how many lines to read. This will return an array
			 * of String , each element is a line from the file.
			 */
			dataFromFile1 = helper.readLineFromFile(file1,file1Grades.length);
			dataFromFile2 = helper.readLineFromFile(file2,file2Grades.length);
			dataFromFile3 = helper.readLineFromFile(file3,file3Grades.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Create a file allGrade.
		File file4 = new File("allGrade.txt");
		
		/*
		 * file1Grades, holds the integer values of the grades in an
		 * int array. The method assignLetterGrades() figure what letter
		 * grade to give them. 
		 */
		char[] letterGrades1=helper.assignLetterGrades(file1Grades);
		char[] letterGrades2=helper.assignLetterGrades(file2Grades);
		char[] letterGrades3=helper.assignLetterGrades(file3Grades);
		
		try {
			/*
			 * 2nd and 3rd params will be written to the File given
			 * in the 1st param
			 */
			helper.writeToFile(file4, dataFromFile1,letterGrades1);
			helper.writeToFile(file4, dataFromFile2,letterGrades2);
			helper.writeToFile(file4, dataFromFile3,letterGrades3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	
		
	}

}
