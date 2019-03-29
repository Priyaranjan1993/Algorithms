package DP;

public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {

		if(s == null || s.length() == 0 || s.length() < 2)
			return s;
		int len = s.length();
		boolean [][] table = new boolean[s.length()][s.length()];
		int maxLength = 1;
    	String result = s.substring(0,1);
		int j = 0;

		for(int  l = 0; l < len; l++)
		{
			for(int i = 0; i < len - l; i++)
			{
				j = i + l;

				if((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || table[i+1][j-1] == true))
				{
					table[i][j] = true;
					if((j - i) +1 > maxLength)
					{
						maxLength = (j-i) + 1;
						result = s.substring(i, j+1);
					}
				}
			}
		}

		return result;
	}
	
	public static void main(String args[])
	{
		LongestPalindromeSubstring l = new LongestPalindromeSubstring();
		String s = "babad";
		System.out.println(l.longestPalindrome(s));
	}
}
