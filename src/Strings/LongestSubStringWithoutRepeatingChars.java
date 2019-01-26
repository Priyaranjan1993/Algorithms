package Strings;
import java.util.*;

public class LongestSubStringWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {

		char[] ch = s.toCharArray();
		int longestLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int i =0; i < ch.length; i++)
		{
			if(!map.containsKey(ch[i]))
			{
				map.put(ch[i], i);
			}
			else {
				i = map.get(ch[i]);
				map.clear();
			}
			if(map.size() > longestLength)
			{
				longestLength = map.size();
			}
		}

		return longestLength;
	}

	public static void main(String args[])
	{
		LongestSubStringWithoutRepeatingChars l = new LongestSubStringWithoutRepeatingChars();
		String s = "pwwkew";
		System.out.println(l.lengthOfLongestSubstring(s));
	}
}
