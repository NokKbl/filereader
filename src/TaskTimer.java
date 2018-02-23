
public class TaskTimer {
	
	public static void measureAndPrint(Runnable runnable) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.printf("Runtime: %.6f sec\n", sw.getElapsed());
	}
}
