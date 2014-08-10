package com.wtsang02.java.rquestion.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.wtsang02.java.rquestion.QuestionModel;

public abstract class AbsQuestionParser {

	protected ArrayList<QuestionModel> data;
	public String file;
	protected boolean vertify;
	protected int max;
	protected int currentParseNumber;
	protected int currentAnswerNumber;
	
	public AbsQuestionParser(File file, int max,boolean vertify) {
		this.vertify=vertify;
		try {
			this.file = readfromfile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		data = new ArrayList<QuestionModel>();
		this.max = max;
		currentParseNumber = 1;
		currentAnswerNumber = 0;

	}
	
	public abstract void parse();

	public ArrayList<QuestionModel> getData() {
		return data;
	}
	
	protected final String readfromfile(File dataFile) throws IOException {
		BufferedReader reader = null;
		String line = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(dataFile));
			for (; (line = reader.readLine()) != null;) {
				sb.append(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			reader.close();
		}
		return sb.toString();
	}
	
	protected <T> void echoIfVertify(T obj){
		if(this.vertify)
		System.out.println(obj);
	}
}
