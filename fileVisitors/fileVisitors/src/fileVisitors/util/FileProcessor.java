package fileVisitors.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import fileVisitors.util.MyLogger;

public class FileProcessor {

	private String s;
	private File file;
	private Scanner sc;

	public FileProcessor(String filename)
	{
		//read from file
		MyLogger.writeMessage("FileProcessor object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
		s = filename;
		file = new File(s);
		try {
			sc = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method read the line from file
	 * @return String the line of a file
	 */
	
	public String readLine()
	{
		if (sc.hasNextLine())
		{ 
			String s1 = sc.nextLine();
			return s1;
		}
		return null;
	}
}
