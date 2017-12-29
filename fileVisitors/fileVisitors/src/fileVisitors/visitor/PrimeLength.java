package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.node.Node;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Results;

public class PrimeLength implements VisitorI
{
	private boolean isPrimeLengthWord = false;

	public PrimeLength()
	{
		MyLogger.writeMessage("PrimeLength object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void visit(Tree tree)
	{
		Node root = tree.getRoot();
		
		if(root != null)
		{
			addSuffix(root);
		}
	}

	/**
	 * This method add the suffix to the word
	 * @param root specify the word which is to be checked to add suffix
	 * @return null
	 */

	public void addSuffix(Node root)
	{
		if(root != null)
		{
			//isPrimeLengthWord = false;
			isPrimeLengthWord = isPrimeLength(root.word);
			if(isPrimeLengthWord == true)
			{
				root.word = root.word + "-PRIME ";
			}
			addSuffix(root.left);
			addSuffix(root.right);
		}
	}

	/**
	 * This method check the length of word is prime or not
	 * @param word specify the word which has to be checked
	 * @return boolean true is prime length else no
	 */
	
	public boolean isPrimeLength(String word)
	{
		int l = word.length();
		boolean isPrimeNumber = false;
		if(l>1)
		{		
			isPrimeNumber = isPrime(l);
		}
		if(isPrimeNumber == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * This method check the integer is prime or not
	 * @param n specify the integer to be checked
	 * @return boolean true if prime else not
	 */

	public boolean isPrime(int n)
	{
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				return false;
			}
    		}
    		return true;
	}
}
