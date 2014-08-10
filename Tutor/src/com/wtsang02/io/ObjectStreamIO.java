package com.wtsang02.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ObjectStreamIO {
	
	private Random generator= new Random();
	private   String NAME_OF_GRADE_FILE  = "grade.txt";
	private   String NAME_OF_BIN_GRADE_FILE = "binarGrade.dat";
	
	public  String getNameOfBinGradeFile() {
		return NAME_OF_BIN_GRADE_FILE;
	}
	
	public int getAverage(String[] grades){
		int sum=0;
		for(int i=0;i<grades.length;i++){
			sum+=Integer.valueOf(grades[i]);//converts back to int and add to sum.
			
		}
		return sum/grades.length;//calculate avg
		
	}

	public File generateGrades(int amount){
		int[] grades=new int[amount];
		for(int i=0;i<grades.length;i++){
			grades[i]=generator.nextInt(101);//0-100
		}
		//fills array with random grades.
		
		File sourceFile=new File(NAME_OF_GRADE_FILE);
		try {
			writeToFile(sourceFile, grades);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sourceFile;
	}


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
	

	public void writeToFile(File targetFile, int[] data) throws IOException {
		BufferedWriter writer = null;
	
		try {
			//@2nd params of FileWriter, when true, 'append' mode.
			writer = new BufferedWriter(new FileWriter(targetFile));
			for(int i=0;i<data.length;i++){
				writer.write(data[i]+"\n");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			writer.close();
		}
		System.out.println("Data is written");
	}
	
	
	
	
	
	
	
}
