package fileVisitors.visitor;

import fileVisitors.tree.Tree;
import fileVisitors.node.Node;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Results;
import fileVisitors.helper.CheckPalindrome;

public class PalindromeHighlight implements VisitorI
{
	private boolean isPalindromeWord = false;
	CheckPalindrome obj = new CheckPalindrome();

	public PalindromeHighlight()
	{
		MyLogger.writeMessage("PalindrromeHighlight object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void visit(Tree tree)
	{
		Node root = tree.getRoot();
		if(root != null)
		{
			toConvert(root);
		}
	}

	public void toConvert(Node root)
	{
		if(root != null)
		{
			isPalindromeWord = obj.isPalindrome(root.word);
			if(isPalindromeWord == true && root.word.length()>3)
			{
				root.word = root.word.toUpperCase();
			}
			toConvert(root.left);
			toConvert(root.right);
		}
	}
}
