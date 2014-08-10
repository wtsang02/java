package com.wtsang02.java.rquestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wtsang02.java.rquestion.parser.AbsQuestionParser;
import com.wtsang02.java.rquestion.parser.QuestionParser300;
import com.wtsang02.java.rquestion.parser.QuestionParser401;
import com.wtsang02.java.rquestion.parser.util.web.HttpPostBuilder;
import com.wtsang02.java.rquestion.parser.util.web.PostData;

public class RQuestionTester {
	private static final String UPLOAD_URL = "http://www.99rounds.com/admin/BatchUploadQuestionServlet";

	private static final String SOURCE_FILE1 = "CSCI_300_FINAL.txt";
	private static final String SOURCE_FILE2 = "CSCI_300_Mid_term_a.txt";
	private static final String SOURCE_FILE3 = "CSCI_300_Mid_term_b.txt";
	private static final String SOURCE_FILE4 = "CSCI_401_Test_1.txt";
	private static final String JSON_FILE = "json_temp.txt";
	private static final String[] SOURCE_FILES = { SOURCE_FILE1, SOURCE_FILE2,
			SOURCE_FILE3, SOURCE_FILE4 };
	private static final int[] SOURCE_QUESTION_NUMBER = { 86, 30, 30, 49 };
	
	private static int maxQuestion;
	private static QuestionModel.Category category;

	public static void main(String[] args) {
		int select = printChooseSourceFiles();
		AbsQuestionParser parser = null;

		File f = new File(SOURCE_FILES[select]);
		maxQuestion = SOURCE_QUESTION_NUMBER[select];
		switch (select) {
		case 0:
		case 1:
		case 2:
			category = QuestionModel.Category.MS_SQL;
			parser = new QuestionParser300(f, maxQuestion, true);
			break;
		case 3:
			category = QuestionModel.Category.Sevlets_And_JSP;
			parser = new QuestionParser401(f, maxQuestion, true);
			break;
		}

		parser.parse();
		ArrayList<QuestionModel> models = parser.getData();

		for (int i = 0; i < models.size(); i++) {
			models.get(i).setType("MCQ");
			models.get(i).setCategory(category.getCategory_id());
			echo((i + 1) + " " + models.get(i).toString());
		}

		send(models);

	}

	/**
	 * Sends to the URL with POST method, then writes to the json_temp.txt file.
	 * 
	 * @param models
	 */
	private static void send(ArrayList<QuestionModel> models) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Type t = new TypeToken<ArrayList<QuestionModel>>() {
		}.getType();
		String json = gson.toJson(models, t);
		HttpPostBuilder builder = new HttpPostBuilder(UPLOAD_URL);
		builder.addPair(GLOBAL.data.toString(), json);
		echo("Sever message returned :  ");
		PostData.printResponse(PostData.postData(builder));
		printToFile(json);
	}

	/**
	 * Print to the json_temp.txt file for debug purpose
	 * 
	 * @param json
	 */
	private static void printToFile(String json) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(JSON_FILE);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		outputStream.print(json);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * Pring the menu
	 * 
	 * @return return the selection -1; So use 0 based index with result.
	 */
	private static int printChooseSourceFiles() {
		for (int i = 0; i < SOURCE_FILES.length; i++) {
			echo((i + 1) + ": " + SOURCE_FILES[i]);
		}
		Scanner in = new Scanner(System.in);
		return in.nextInt() - 1;
	}

	/**
	 * Override the method s.o.pln() ;
	 * 
	 * @param obj
	 */
	public static <T> void echo(T obj) {
		System.out.println(obj);
	}
}
