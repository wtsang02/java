package com.wtsang02.java.rquestion.parser.util;

public class ParseUtil {

	public static final String trimAllSpace(String text){
		return text.replaceAll(" ", "");
	}
	public static final String removeReduntantQuestionNumber(String text){
		return text.replaceAll("\\d+\\)", "");
	}
}
