package com.wtsang02.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

	public class StudentGradeTester {
		
		public static void main(String[] args) {
			System.out.println("Enter a file name of yor choice.");
			Scanner file = new Scanner(System.in); // Allows user to input their own
													// file name
			String fileName = file.nextLine();
			PrintWriter outputStream = null; // Declares stream variable

			System.out.println("File name is " + fileName);
			try {
				outputStream = new PrintWriter(fileName); // Makes new output stream
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file" + fileName);
				System.exit(0);
			}

			int totalGrade = 0;
			Scanner keyboard = new Scanner(System.in);
			System.out.println(" Please enter the number of students you have in the class.");
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
			
			// ------------------------------------------------------------

			File targetFile = new File("targetFile");
			
			if (targetFile.exists()) {
				System.out.println("target file already exists");
				System.exit(0);
			}
			
			File sourceFile=new File(fileName);
			
			Scanner input=null;
			try {
				input = new Scanner(sourceFile);
			} catch (FileNotFoundException e1) {
			
				e1.printStackTrace();
			}
			
			PrintWriter output = null;
			try {

				output = new PrintWriter(targetFile);
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file" + targetFile);
				System.exit(0);
			}
			while (input.hasNext()) {
				String s1 = input.nextLine();
				if (s1.contains("grade is 100")) {
					output.println(s1);
				}
			}
			input.close();
			output.close();
			System.out.println("String has been written");

		}

}
