package utility;

public class StopWatch {
	public StopWatch() {
		reset();
	}

	public void start() {
		if (isRunning)
			return;
		isRunning = true;
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		if (!isRunning)
			return;
		isRunning = false;
		long endTime = System.currentTimeMillis();
		elapsedTime = elapsedTime + endTime - startTime;
	}

	public double getEleapsedTime() {
		double seconds;
		if (isRunning) {
			long endTime = System.currentTimeMillis();
			seconds = (elapsedTime + endTime - startTime) * 0.001;
			return seconds;
		} else {
			seconds = elapsedTime * 0.001;
			return seconds;
		}
	}

	public void reset() {
		elapsedTime = 0;
		isRunning = false;
	}

	public void printTime() {
		System.out.println(getEleapsedTime() + " seconds used.");
	}

	private long elapsedTime;
	private long startTime;
	private boolean isRunning;
}