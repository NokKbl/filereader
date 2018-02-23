/**
 * TaskTimer runs a task using a Stopwatch and prints the elapsed time.
 * 
 * @author Kunyaruk Katebunlu
 */
public class TaskTimer {
	
	/**
	 * Runs a task, measures and prints its running time to the console.
	 * @param runnable is a task that need to run.
	 */
	public static void measureAndPrint(Runnable runnable) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.printf("Runtime: %.6f sec\n", sw.getElapsed());
	}
	
}
