/**
 * Main class for creates tasks and pass each task to TaskTimer.
 * 
 * @author Kunyaruk Katebunlu
 */
public class Main {

	/**
	 * Creates the tasks and pass each task to the TaskTimer.
	 * @param args is not use.
	 */
	public static void main(String[] args) {
		String filename = "AliceInWonderland.txt";
		Runnable[] tasks = { new ReadFileToString(filename),
                				new ReadFileToStringBuilder(filename),
                				new ReadFileByBufferedReader(filename)};
		
		for (Runnable runnable : tasks) {
			System.out.println(runnable.toString());
			TaskTimer.measureAndPrint(runnable);
		}
	}

}
