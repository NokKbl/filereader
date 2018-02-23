import java.io.*;

/**
 * ReadFileByBufferedReader class use to do "read String by BufferedReader" task.
 * This class implements Runnable interface and override run() and toString() methods.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ReadFileByBufferedReader implements Runnable {
	/** Length of characters in the specify file */
	private int size;
	/** Name of specify file */
	private String filename;
	
	/**
	 * Receive and remember the value of filename.
	 * @param filename is file that want to read.
	 */
	public ReadFileByBufferedReader(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Read specify file by BufferedReader and return String of data.
	 * @param filename is the specify file.
	 * @return String of data that read from the file.
	 */
	public static String readFileByBufferedReader(String filename) {
		String data = "";
		InputStream in = null;
		
		try {
			in = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String result;
			while((result = reader.readLine()) != null) data = data + result + "\n";
		} catch (FileNotFoundException fx) { 
			System.out.println("file not found " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try { 
			if(in!= null) in.close();
		} catch (IOException ioe) { /* ignore it*/}
		
		return data;
	}
	
	/**
	 * Perform the task by calling readFileByBufferedReader() method.
	 */
	@Override
	public void run() {
		readFileByBufferedReader(filename);
	}
	
	/**
	 * Return a description of "read String by BufferedReader" task.
	 */
	@Override
	public String toString() {
		size = readFileByBufferedReader(filename).length();
		return "Read "+ filename + " that contains " + size + " chars by BufferedReader, append lines to String.";
	}

}
