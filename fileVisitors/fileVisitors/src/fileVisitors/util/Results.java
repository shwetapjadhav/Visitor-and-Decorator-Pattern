package fileVisitors.util;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import fileVisitors.util.MyLogger;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	ArrayList<String> result;
	FileWriter fw = null;
	BufferedWriter bw = null;

	public Results()
	{
		result = new ArrayList<String> ();
		MyLogger.writeMessage("Result object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method add the result into ArrayList
	 * @param s is result to be added into arraylist
	 * @return null
	 */

	public void storeNewResult(String s)
	{
		MyLogger.writeMessage("New Result is added into the array",MyLogger.DebugLevel.FROM_RESULTS);
		result.add(s);
	}


	//@Override
	public void writeToStdout()
	{
		for(int i=0; i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
	}

	//@Override
	public void writeToFile(String s1)
	{
		try
		{
			fw = new FileWriter(s1);
			bw = new BufferedWriter(fw);
			for(int i=0;i<result.size();i++)
			{
					bw.write(result.get(i));
					bw.write("\n");
			}
			MyLogger.writeMessage("Result is written into the file",MyLogger.DebugLevel.IN_RESULTS);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bw.close();
				fw.close();
			}
			catch(IOException e)
			{e.printStackTrace();}
		}
	}	
}
