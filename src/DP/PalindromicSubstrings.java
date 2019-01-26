package DP;

public class PalindromicSubstrings {
	int count = 1;
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0)
		{
			return 0;
		}
		for(int i =0; i < s.length() - 1; i++)
		{
			countPal(s,i,i);
			countPal(s,i,i+1);
		}
		return count;
	}

	private void countPal(String s, int i, int j) {
		while(i >= 0 && j<s.length() && s.charAt(i) == s.charAt(j))
		{
			count++;
			i--;
			j++;
		}
	}

	public static void main(String args[])
	{
		PalindromicSubstrings p = new PalindromicSubstrings();
		String s = "aabaa";
		System.out.println(p.countSubstrings(s));
	}
}
