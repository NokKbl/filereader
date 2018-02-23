import java.io.*;

public class ReadFileToString implements Runnable{
	
	private int size;
	private String filename;
	
	public ReadFileToString(String filename) {
		this.filename = filename;
	}
	
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
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(in!= null) in.close();
		} catch (IOException ioe) { /* ignore it*/}
		
		return data.toString();
	}
	
	@Override
	public void run() {
		readFileToString(filename);
	}
	
	@Override
	public String toString() {
		size = readFileToString(filename).length();
		return "Read "+ filename + " that contains " + size + " chars by InputStreamReader, append to String.";
	}

}
