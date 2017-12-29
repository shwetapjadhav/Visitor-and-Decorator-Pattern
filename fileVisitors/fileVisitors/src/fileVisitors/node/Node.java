package fileVisitors.node;

import fileVisitors.util.MyLogger;

public class Node
{
	public String word;

	public Node left = null;
	public Node right = null;
	

	public Node()
	{
		MyLogger.writeMessage("Node object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}
}
