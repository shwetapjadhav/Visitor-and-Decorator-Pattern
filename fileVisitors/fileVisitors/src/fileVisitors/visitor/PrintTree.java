package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.node.Node;
import fileVisitors.util.Results;
import fileVisitors.util.MyLogger;

public class PrintTree implements VisitorI
{

	private Results rs;
	public PrintTree(Results results)
	{
		rs = results;
		MyLogger.writeMessage("PrintTree object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}
	public void visit(Tree tree)
	{
		Node root = tree.getRoot();
		if(root != null)
		{
			printNode(root);
		}
	}

	/**
	 * This method print the result
	 * @param root specify the root of the tree
	 * @return null
	 */

	public void printNode(Node root)
	{
		if(root != null)
         	{
         		printNode(root.left);
			//System.out.println(root.word);
			rs.storeNewResult(root.word);
			printNode(root.right);
		}
	}
}
