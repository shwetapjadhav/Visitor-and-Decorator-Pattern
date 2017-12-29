package fileVisitors.driver;

import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.tree.Tree;
import fileVisitors.util.Results;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.VisitorI;

public class Driver
{
	public static void main(String args[])
	{

		if(args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || Integer.parseInt(args[2])<0 || Integer.parseInt(args[2]) > 4)
		{
			System.err.println("Invalid Number of Arguments!!");
			System.exit(0);
		}
		
		Results rs = new Results();
		MyLogger.setDebugValue(Integer.parseInt(args[2]));
		VisitorI populatevisitor = new PopulateVisitor(args[0]);
		VisitorI primelength = new PrimeLength();
		VisitorI palhighlight = new PalindromeHighlight();
		VisitorI printtree = new PrintTree(rs);
		Tree tree = new Tree();

		tree.accept(populatevisitor);
		tree.accept(palhighlight);
		tree.accept(primelength);
		tree.accept(printtree);

		rs.writeToFile(args[1]);
		rs.writeToStdout();
	}
}
