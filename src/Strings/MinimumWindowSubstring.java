package Strings;
import java.util.*;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		char[] ch = t.toCharArray();
		char[] ss = s.toCharArray();
		for(char c : ch)
		{
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c : ss)
		{
			map.put(c, map.getOrDefault(c, 0));
		}
		int length = s.length();
		
		int l = 0, r = 0, i = 0 , j = 0 , missing = t.length(); 
		while(r < length)
		{
			if(map.get(ss[r]) != null && map.get(ss[r]) > 0)
			{
				missing = missing - 1;
			}
			map.put(ss[r], map.get(ss[r]) - 1);
			r = r+1;
			while(missing == 0)
			{
				if(j == 0 || r - l < j - i)
				{
					i = l;
					j = r;
				}
				
				
				map.put(ss[l], map.get(ss[l])+1);
				if(map.get(ss[l]) > 0)
				{
					missing = missing + 1;
				}
				l = l + 1;
			}
		}
		return s.substring(i, j);
	}
	
	public static void main(String args[])
	{
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(m.minWindow(s, t));
	}
}
