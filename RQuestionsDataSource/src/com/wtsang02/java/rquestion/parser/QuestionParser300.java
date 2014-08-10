package com.wtsang02.java.rquestion.parser;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wtsang02.java.rquestion.QuestionModel;
import com.wtsang02.java.rquestion.parser.util.ParseUtil;

public class QuestionParser300 extends AbsQuestionParser {

	public QuestionParser300(File file, int max, boolean vertify) {
		super(file, max, vertify);
		System.out.println("Using 300 parser");
	}




	public void parse() {
		Pattern pattern = Pattern.compile("\\d+\\)");
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

			question = ParseUtil.removeReduntantQuestionNumber(question);

			startingPoint = endQuestion;

			findAnswers(startQuestion, endOfWholeQuestion);
			super.currentParseNumber++;
		}

	}

	private int findEndOfWholeQuestion(int startQuestion, int realQuestionNumber) {
		Pattern pattern = Pattern.compile("\\d+\\)");
		Matcher matcher = pattern.matcher(super.file);
		while (matcher.find(startQuestion)) {
			String parsedNumber = super.file.substring(matcher.start(),
					matcher.end() - 1);
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
		wholeQuestion = ParseUtil.removeReduntantQuestionNumber(wholeQuestion);
		String[] answers = wholeQuestion.split("[A-Z]\\)");

		if (answers.length != 5) {
			System.out.println("NOT CORRECT FORMAT, Q: "
					+ super.currentParseNumber + "  NUMBERS:" + answers.length);
			System.out.println(wholeQuestion);
		}
		QuestionModel model = new QuestionModel();
		model.setQuestion(answers[0]);
		for (int i = 1; i < answers.length; i++) {
			model.addAnswer(answers[i]);
		}
		super.data.add(model);

	}

	private int isAnswerCheck(int startQuestion) {
		Pattern pattern = Pattern.compile("\\s{1}\\w{1}\\s{1}");
		Matcher matcher = pattern.matcher(file);
		if (matcher.find(startQuestion)) {

			String letterAnswer = super.file.substring(matcher.start(),
					matcher.end());

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
		int i = Integer.parseInt(parsedNumberString);
		if (i != actual) {

			return -1;
		}
		return i;
	}

	private int findEndOfQuestion(int startQuestion) {
		Pattern pattern = Pattern.compile("A\\)");
		Matcher matcher = pattern.matcher(super.file);
		if (matcher.find(startQuestion)) {

			return matcher.start();

		}
		return -1;
	}

}
