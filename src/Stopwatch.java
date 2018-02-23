public class Stopwatch {
	private static final double NANOSECOND = 1.0E-9;
	private long startTime;
	private long stopTime;
	private boolean running;
	
	/** Start the stopwatch */
	public void start() {
		if(running) return;
		startTime = System.nanoTime();
		running = true;
	}
	
	/** Stop the stopwatch */
	public void stop() {
		if(!running) return;
		stopTime = System.nanoTime();
		running = false;
	}
	
	/** Test if the stopwatch is running. */
	public boolean isRunning() {
		return running;
	}
	
	/** Get the elapsed time in seconds */
	public double getElapsed() {
		// No Magic Numbers in Code - "Code Complete"
		if(running) return (System.nanoTime() - startTime)*NANOSECOND;
		else return (stopTime - startTime)*NANOSECOND;
	}
}
