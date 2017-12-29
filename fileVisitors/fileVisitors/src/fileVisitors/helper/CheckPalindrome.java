package fileVisitors.helper;

public class CheckPalindrome
{

	/**
	 * This method check the word is palindrome or not
	 * @param word specify the word which is to be checked
	 * @return boolean true is word is palindrome false is not
	 */
	public boolean isPalindrome(String word)
	{
		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i-- )
		{
         		reverse = reverse + word.charAt(i);
		}

		if (word.equalsIgnoreCase(reverse))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
