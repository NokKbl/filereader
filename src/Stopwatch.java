/**
 *  Stopwatch class use to compute elapsed time between a start and stop time.
 * 
 * @author Kunyaruk Katebunlu
 */
public class Stopwatch {
	/** the default denominator for change nanoseconds to seconds*/
	private static final double NANOSECOND = 1.0E-9;
	/** time that start the stopwatch */
	private long startTime;
	/** time that stop the stopwatch */
	private long stopTime;
	/** boolean for check that stopwatch is running or not */
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
		if(running) return (System.nanoTime() - startTime)*NANOSECOND;
		else return (stopTime - startTime)*NANOSECOND;
	}
	
}
