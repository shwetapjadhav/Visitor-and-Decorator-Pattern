package fileVisitors.tree;

import fileVisitors.node.Node;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.VisitorI;
import fileVisitors.util.Results;


public class Tree
{
	private Node root;
	private int count = 0;

	public Tree()
	{
		MyLogger.writeMessage("Tree object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
		root = null;
	}

	/**
	 * This method search the specified node
	 * @param search_word specify the word which has to be search
	 * @return Node return the node of the specified word
	 */

	public Node search(String search_word)
	{

		Node current = root;
		while(current != null && !current.word.equals(search_word))
		{
			int temp = search_word.compareTo(current.word);
			if(temp<0)
			{
				current = current.left;
			}
		        else
			{
				current = current.right;
			}
		
		}
      		return current;
	}

	/**
	 * This method insert the new word into tree
	 * @param insert_word specify the word which has to be inserted
	 * @return null
	 */

	public void insert(String insert_word)
	{
		Node available;
		available = search(insert_word);
		
		if(available == null)
		{
			available = new Node();

			available.word = insert_word;

			if(root==null)
			{
				root = available;
				count++;
				MyLogger.writeMessage(count+" New Node Created for "+available.word,MyLogger.DebugLevel.NODE_CREATE);
			}
			else
			{
				insertNode(root,available);
				count++;
				MyLogger.writeMessage(count+". New Node Created for "+ available.word,MyLogger.DebugLevel.NODE_CREATE);
			}
		}
	}


	public void insertNode(Node root, Node currentNode)
	{
		Node current = root;
        	Node parent;
		String insert_word = currentNode.word;
        	while(true)
        	{
			parent = current;
			int temp = insert_word.compareTo(current.word);
			if(temp < 0)
			{
				current = current.left;
				if(current == null)
                		{
                			parent.left = currentNode;
                			return;
                		}
               		}
           		else
			{
				current = current.right;
				if(current == null)
                		{
                			parent.right = currentNode;
                			return;
                		}
               		}
           	}
         }

	/**
	 * This method returns the root of tree
	 * @return Node returns the root of the tree
	 */

	public Node getRoot()
	{
		return root;
	}

	public void accept(VisitorI visitor)
	{
		visitor.visit(this);
	}


}
