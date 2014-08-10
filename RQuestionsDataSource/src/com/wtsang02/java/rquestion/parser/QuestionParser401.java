package com.wtsang02.java.rquestion.parser;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wtsang02.java.rquestion.QuestionModel;

public class QuestionParser401 extends AbsQuestionParser {

	public QuestionParser401(File file, int max, boolean vertify) {
		super(file, max, vertify);
		System.out.println("Using 401 parser");
	}

	@Override
	public void parse() {
		Pattern pattern = Pattern.compile("\\d+\\.");
		Matcher matcher = pattern.matcher(super.file);
		int startingPoint = 0;
		boolean areAnswers = false;
		while (matcher.find(startingPoint)) {
			if (super.currentParseNumber > super.max) {
				areAnswers = true;
				// System.out.println(this.currentParseNumber+" "+this.max);
			}

			int startQuestion = matcher.end();
			int realQuestionNumber = checkProgress(matcher,
					this.currentParseNumber);

			// super.echoIfVertify(super.file.substring(startQuestion,
			// endIndex));
			if (realQuestionNumber == -1) {
				if (areAnswers) {
					if (super.currentAnswerNumber >= super.data.size()) {
						return;
					}
					startingPoint = isAnswerCheck(startQuestion);
					continue;
				} else {
					startingPoint = startQuestion;
					continue;
				}
			}

			int endQuestion = findEndOfQuestion(startQuestion);
			int endOfWholeQuestion = findEndOfWholeQuestion(startQuestion,
					realQuestionNumber);

			if (endOfWholeQuestion == -1) {
				currentParseNumber++;

				continue;
			}
			String question = super.file.substring(startQuestion, endQuestion);

			startingPoint = endQuestion;

			findAnswers(startQuestion, endOfWholeQuestion);
			super.currentParseNumber++;
		}

	}

	private int findEndOfWholeQuestion(int startQuestion, int realQuestionNumber) {
		Pattern pattern = Pattern.compile("[_+]\\s\\d+\\.");
		Matcher matcher = pattern.matcher(super.file);
		while (matcher.find(startQuestion)) {
			String parsedNumber = super.file.substring(matcher.start(),
					matcher.end() - 1);
			parsedNumber = parsedNumber.replaceAll("_", "").trim();
			int actualNumber = Integer.parseInt(parsedNumber);
			// actualNumber==1 is last entry, where 1 is the answer key of 1)
			if (actualNumber == realQuestionNumber + 1
					| (actualNumber == 1 && super.currentParseNumber != 1)) {
				if (matcher.start() - 1 > super.file.length()) {
					return super.file.length() - 1;
				} else {
					return matcher.start() - 1;
				}
			}
			startQuestion = matcher.end();

		}
		return -1;
	}

	private void findAnswers(int startingPoint, int endOfWholeQuestion) {
		String wholeQuestion = file
				.substring(startingPoint, endOfWholeQuestion);

		String[] answers = wholeQuestion
				.split("\\s{1}[a-z]\\.\\s{1}|\\r?\\n[a-z]\\.\\s{1}");

		if (answers.length != 5) {
		//	super.echoIfVertify("NOT CORRECT FORMAT, Q: "
			//		+ super.currentParseNumber + "  NUMBERS:" + answers.length);
			// if(currentParseNumber==40){
			// for(int i=0;i<answers.length;i++){
			// super.echoIfVertify(answers[i]);
			// }
			// }
		}
		QuestionModel model = new QuestionModel();
		model.setQuestion(answers[0]);
		for (int i = 1; i < answers.length; i++) {
			if (answers[i].endsWith("_")) {
				
				answers[i]=trimAll(answers[i].trim(),'_');
			}
			model.addAnswer(answers[i]);
		}
		super.data.add(model);

	}

	private int isAnswerCheck(int startQuestion) {
		Pattern pattern = Pattern.compile("[ANS:]\\s{1}\\w{1}\\s{1}");
		Matcher matcher = pattern.matcher(file);
		if (matcher.find(startQuestion)) {

			String letterAnswer = super.file.substring(matcher.start(),
					matcher.end());
			letterAnswer = letterAnswer.replace("ANS: ", "").trim();
			super.data.get(currentAnswerNumber).setrAnswer(letterAnswer);
			currentAnswerNumber++;
			return matcher.end();
		}
		return startQuestion;
	}

	/**
	 * 
	 * @param matcher
	 * @param actual
	 * @return -1 when done or parse fail.
	 */
	private final int checkProgress(Matcher matcher, int actual) {
		String parsedNumberString = super.file.substring(matcher.start(),
				matcher.end() - 1);
		parsedNumberString = parsedNumberString.replaceAll("_", "").trim();
		int i = Integer.parseInt(parsedNumberString);
		if (i != actual) {
			// super.echoIfVertify(" NOT IN SYNC  "+" "+actual+" "+i);
			return -1;
		}
		return i;
	}

	private int findEndOfQuestion(int startQuestion) {
		Pattern pattern = Pattern.compile("a\\.");
		Matcher matcher = pattern.matcher(super.file);
		if (matcher.find(startQuestion)) {

			return matcher.start();

		}
		return -1;
	}

	public String trimAll(String str, char trim) {

		while (str.length() > 0 && str.charAt(str.length() - 1)== trim) {
			str = str.substring(0, str.length() - 1);
	//		super.echoIfVertify(str);
		}
		return str;

	}
}
