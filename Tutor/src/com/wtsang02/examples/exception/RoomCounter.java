package com.wtsang02.examples.exception;
public class RoomCounter {

	private int counter;

	public int getCounter() {
		return counter;
	}

	public void addPerson() {
		counter++;
	}

	public void removePerson() {
		try {
			if ((counter-1) < 0) {
			//	counter++;
				throw new NegativeCounterException(counter);
			} else {
				counter--;
			}

		} catch (NegativeCounterException e) {
			e.errorMsg();
		}
	}
}
