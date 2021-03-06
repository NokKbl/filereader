import java.io.*;

/**
 * ReadFileByBufferedReader class use to do "read String by InputStreamReader" task.
 * This class implements Runnable interface and override run() and toString() methods.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ReadFileToString implements Runnable{
	/** Length of characters in the specify file */
	private int size;
	/** Name of specify file */
	private String filename;
	
	/**
	 * Receive and remember the value of filename.
	 * @param filename is file that want to read.
	 */
	public ReadFileToString(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Read String from specify file by InputStreamReader and return String of data.
	 * @param filename is the specify file.
	 * @return String of data that read from the file.
	 */
	public static String readFileToString(String filename) {
		String data = "";
		InputStream in = null;
		
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while(true) {
				c = reader.read();
				if(c < 0) break;
				data = data + (char) c;
			}
		} catch (FileNotFoundException fx) { 
			System.out.println("file not found " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(in!= null) in.close();
		} catch (IOException ioe) { /* ignore it*/}
		
		return data.toString();
	}
	
	/**
	 * Perform the task by calling readFileToString() method.
	 */
	@Override
	public void run() {
		readFileToString(filename);
	}
	
	/**
	 * Return a description of "read String by InputStreamReader" task.
	 */
	@Override
	public String toString() {
		size = readFileToString(filename).length();
		return "Read "+ filename + " that contains " + size + " chars by InputStreamReader, append to String.";
	}

}
