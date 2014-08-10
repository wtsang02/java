package com.wtsang02.java.rquestion;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class QuestionModel {
	@Expose
	private String question;
	@Expose
	private ArrayList<String> answers;
	@Expose
	private String rAnswer;
	@Expose
	private String type;// MCQ
	@Expose
	private int category;

	private String explanation;
	private long _id;
	private String origin_link;
	private int version;
	private long create_unixtime;
	
	
	public String getOrigin_link() {
		return origin_link;
	}

	public void setOrigin_link(String origin_link) {
		this.origin_link = origin_link;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getCreate_unixtime() {
		return create_unixtime;
	}

	public void setCreate_unixtime(long create_unixtime) {
		this.create_unixtime = create_unixtime;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}



	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public QuestionModel() {
		answers = new ArrayList<String>();
	}

	public void addAnswer(String answer) {
		this.answers.add(answer);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public String getrAnswer() {
		return rAnswer;
	}

	public void setrAnswer(String rAnswer) {
		this.rAnswer = rAnswer;
	}

	@Override
	public String toString() {
		char c = 'A';
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < answers.size(); i++) {
			answer.append(c + ")" + answers.get(i) + "\n");
			c++;
		}
		return this.category+"  "+this.question + "\n" + answer.toString() + "Answer: "
				+ this.rAnswer + "\n";
	}

	public enum Category {

		General(1), MS_SQL(2), Sevlets_And_JSP(3), Java(4);

		int category_id;

		public int getCategory_id() {
			return category_id;
		}

		private Category(int i) {
			category_id = i;
		}
	}
}
