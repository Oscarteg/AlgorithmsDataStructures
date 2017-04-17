package main.utils;

/**
 * Created by Oscar on 13/04/2017.
 */
public class StopWatch {

	private long startTime;

	public StopWatch() {
		startTime = System.nanoTime();
	}

	public long getElapsedTime() {
		return (System.nanoTime() - this.startTime) / 1000;
	}

	@Override
	public String toString() {
		return " Elapsed time: " + this.getElapsedTime() + "ms";
	}
}
