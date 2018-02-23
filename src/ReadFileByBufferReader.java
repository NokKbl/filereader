import java.io.*;

public class ReadFileByBufferReader implements Runnable {
	
	private int size;
	private String filename;
	
	public ReadFileByBufferReader(String filename) {
		this.filename = filename;
	}
	
	public static String readFileByBufferReader(String filename) {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String result;
			while((result = reader.readLine()) != null) data = data + result + "\n";
			
		} catch (FileNotFoundException fx) { 
			System.out.println("file not found " + filename);
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(in!= null) in.close();
		} catch (IOException ioe) { /* ignore it*/}
		
		return data;
	}
	
	@Override
	public void run() {
		readFileByBufferReader(filename);
	}
	
	@Override
	public String toString() {
		size = readFileByBufferReader(filename).length();
		return "Read "+ filename + " that contains " + size + " chars by BufferReader, append lines to String.";
	}

}
