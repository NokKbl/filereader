
public class Main {

	public static void main(String[] args) {
		String filename = "AliceInWonderland.txt";
		Runnable[] tasks = { new ReadFileToString(filename),
                				new ReadFileToStringBuilder(filename),
                				new ReadFileByBufferReader(filename)};
		
		for (Runnable runnable : tasks) {
			System.out.println(runnable.toString());
			TaskTimer.measureAndPrint(runnable);
		}
	}

}
