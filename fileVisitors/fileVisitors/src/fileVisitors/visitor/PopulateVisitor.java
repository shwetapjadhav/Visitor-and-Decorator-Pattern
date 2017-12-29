package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Results;

public class PopulateVisitor implements VisitorI
{
	FileProcessor fileprocessor;

	public PopulateVisitor(String filename)
	{
		MyLogger.writeMessage("PopulateVisitor object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
		fileprocessor  = new FileProcessor(filename);
	}

	public void visit(Tree tree)
	{
		String s1 = null;
		while((s1 = fileprocessor.readLine()) != null)
		{
			if(s1.isEmpty())
			{
				continue;
			}
			String[] temp = s1.split("\\s+");
			for(int i=0;i<temp.length;i++)
			{
				tree.insert(temp[i]);
			}
		}
	}
}
