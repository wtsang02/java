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

public class FileTextIO {
	public static final String SOURCE_FILE = "data.txt";

	/*
	 * This is the last lab,if 'true' was passed user manually enters the data,
	 * if 'false' static data is generated.
	 */
	public String generateData(boolean manual) {
		if (manual) {
			System.out.println("Enter a file name of yor choice.");
			Scanner file = new Scanner(System.in); // Allows user to input their
													// own // file name
			String fileName = file.nextLine();
			PrintWriter outputStream = null; // Declares stream variable
			System.out.println("File name is " + fileName);
			try {
				outputStream = new PrintWriter(fileName); // Makes new output
															// stream
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file" + fileName);
				System.exit(0);
			}
			int totalGrade = 0;
			Scanner keyboard = new Scanner(System.in);
			System.out
					.println(" Please enter the number of students you have in the class.");
			int entryAmount = keyboard.nextInt();
			for (int k = 1; k <= entryAmount; k++) {
				System.out.println("Enter 1 student name: ");
				String name = keyboard.next();
				outputStream.print("The students name is " + name + ". ");
				System.out.println("Enter 1 student grade: ");
				int grade = keyboard.nextInt();
				totalGrade += grade;
				outputStream.print(" Their grade is " + grade + ". ");

				System.out.println("Enter 1 student age: ");
				int age = keyboard.nextInt();
				outputStream.println(" They are " + age + " old.");
			}
			outputStream.println("Avg Grade is:" + totalGrade / entryAmount);
			outputStream.close(); // Puts everything in to the file
			System.out.println("Grades were written to " + fileName);
			return fileName;
		} else {
			return generateStaticData();
		}
	}

	// this methods writes static data into the source_file and returns the name
	// of the file.
	private String generateStaticData() {
		File file = new File(SOURCE_FILE);
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printer.write("The students name is fjse.  Their grade is 100.  They are 32 old. \n "
				+ "The students name is gjse.  Their grade is 34.  They are 45 old. \n"
				+ "The students name is gdrj.  Their grade is 100.  They are 45 old. \n"
				+ "Avg Grade is:78");
		printer.close();
		return SOURCE_FILE;
	}

	/*
	 * This method returns the lines in a File that matches the 2nd params.
	 */
	public String getMatchedData(File dataFile, String matchingData)
			throws IOException {
		BufferedReader reader = null;
		String line = null;
		StringBuilder returningData = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(dataFile));
			while ((line = reader.readLine()) != null) {
				if (line.contains(matchingData)) {
					returningData.append(line + "\n");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			reader.close();
		}
		return returningData.toString();
	}

	public String[] readLineFromFile(File dataFile,int lines) throws IOException {
		BufferedReader reader = null;
		String line = null;
		String[] returningData = new String[lines];

		try {
			reader = new BufferedReader(new FileReader(dataFile));

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
	public void writeToFile(File targetFile, String data) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(targetFile));
			writer.write(data);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			writer.close();
		}
		System.out.println("Data is written");
	}
	public void writeToFile(File targetFile, String[] data,char[] data2) throws IOException {
		BufferedWriter writer = null;
	
		try {
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

	private int[] grades;

	public int[] getGrades() {
		return grades;
	}

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
