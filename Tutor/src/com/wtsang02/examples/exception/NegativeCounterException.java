package com.wtsang02.examples.exception;
public class NegativeCounterException extends Exception {
	int counter;

	NegativeCounterException(int counter) {
		this.counter=counter;
	}

	public void errorMsg() {
		System.out.println("Cannot be:" + counter);
	}
}
