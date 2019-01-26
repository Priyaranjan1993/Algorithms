package Strings;

public class FirstUniqueCharInString {
	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		for(int i=0; i< s.length(); i++)
		{
			arr[s.charAt(i) - 'a']++;
		}
		for(int k=0; k<s.length();k++)
		{
			if(arr[s.charAt(k) - 'a'] == 1)
			{
				return k;
			}
		}
		return -1;
	}

	public static void main(String args[])
	{
		FirstUniqueCharInString f = new FirstUniqueCharInString();
		String s = "loveleetcode";
		System.out.println(f.firstUniqChar(s));
	}
}
