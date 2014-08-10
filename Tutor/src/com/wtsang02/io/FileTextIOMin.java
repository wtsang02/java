package com.wtsang02.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTextIOMin {
	
	private int[] grades;
	
	/*
	 * Reads the dataFile at 1st params for (2nd params) amount of lines.
	 */
	public String[] readLineFromFile(File dataFile,int lines) throws IOException {
		BufferedReader reader = null;
		String line = null;
		String[] returningData = new String[lines];

		try {
			
			reader = new BufferedReader(new FileReader(dataFile));
			/*
			 * reader.readLine(), will read one line, assign it to var line, then
			 * check if (!=null). reader.readLine() will return null when
			 * it reaches the end of the document
			 */
			for (int i = 0; (line = reader.readLine()) != null; i++) {
				returningData[i] = line;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			reader.close();
		}
		return returningData;
	}

	/*
	 * Writes 2nd params(data) into the 1st params(targetFile)
	 */

	public void writeToFile(File targetFile, String[] data,char[] data2) throws IOException {
		BufferedWriter writer = null;
	
		try {
			//@2nd params of FileWriter, when true, 'append' mode.
			writer = new BufferedWriter(new FileWriter(targetFile,true));
			for(int i=0;i<data.length;i++){
				writer.write(data[i]+" "+data2[i]+"\n");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			writer.close();
		}
		System.out.println("Data is written");
	}



	public int[] getGrades() {
		return grades;
	}

	//Lab 5, except user don't input file name, it will be given by params
	public File createGradeFileFromUser(String fileName) {
		File file = new File(fileName);

		PrintWriter outputStream = null; // Declares stream variable
		System.out.println("writing to " + fileName);
		try {
			outputStream = new PrintWriter(file); // Makes new output
													// stream
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
			System.exit(0);
		}
		Scanner keyboard = new Scanner(System.in);
		System.out
				.println(" Please enter the number of students you have in the class.");
		int entryAmount = 2;
		grades = new int[entryAmount];
		for (int k = 1; k <= entryAmount; k++) {
			System.out.println("Enter 1 student first name: ");
			String fName = keyboard.next();
			outputStream.print("The students first name is " + fName + ". ");

			System.out.println("Enter 1 student last name: ");
			String lName = keyboard.next();
			outputStream.print("last name is " + lName + ". ");

			System.out.println("Enter 1 student grade: ");
			int grade = keyboard.nextInt();

			outputStream.println(" Their grade is " + grade + ". ");

			grades[k-1] = grade;

		}
		outputStream.close(); // Puts everything in to the file
		
		return file;
	}

	/*
	 * The keyword 'continue' means stop the current iteration of forloop;
	 * and continue on to the next. ex. if 78 was passed in it will skip
	 * first if statment, and execute the 2nd if statment. when it hits,
	 * the 'continue'; it will stop and never execute next line which is
	 * (if(grades[i]<80)... it will do i++ and continue the loop.
	 */
	public char[] assignLetterGrades(int[] grades) {
		char[] returningData = new char[grades.length];
		
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < 60) {
				returningData[i] = 'F';
				continue;
			}
			if (grades[i] < 70) {
				returningData[i] = 'D';
				continue;
			}
			if (grades[i] < 80) {
				returningData[i] = 'C';
				continue;
			}
			if (grades[i] < 90) {
				returningData[i] = 'B';
				continue;
			}else{
			returningData[i] = 'A';
			}
		}
		return returningData;

	}
}
