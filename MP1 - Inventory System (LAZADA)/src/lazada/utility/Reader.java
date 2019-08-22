package lazada.utility;


import java.io.*;

public class Reader {

	private static BufferedReader getReader() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		return reader;
	}
	
	public static String readString(String message) 
		throws IOException {
		
		String input = null;
		
		System.out.print(message);
		
		BufferedReader reader = getReader();
		
		input = reader.readLine();
		
		return input;
	}
	
	public static char readChar(String message)
		throws IOException{
		
		char input;
		
		System.out.println(message);
		
		BufferedReader reader = getReader();
		
		input = (char) reader.read();
		
		return input;
	}
	public static boolean readBoolean(String message) throws IOException {
		
		boolean input = false;
		
		System.out.print(message);
		
		input = Boolean.parseBoolean(getReader().readLine());
		
		return input;
	}
	public static int readInt(String message) throws IOException {
		
		int input = 0;
		
		System.out.print(message);
		
		input = Integer.parseInt(getReader().readLine());
		
		return input;
	}
	
	public static double readDouble(String message) throws IOException {
		
		double input = 0;
		
		System.out.print(message);
		
		input = Double.parseDouble(getReader().readLine());
		
		return input;
	}
	
}
