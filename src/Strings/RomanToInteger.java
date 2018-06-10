package Strings;

import java.util.HashMap;

class Solution {
	HashMap<Character, Integer> hm= new HashMap<Character,Integer>();

	Solution()
	{

		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);


	}


	public int romanToInt(String s) {
		int result = 0;
		int val, val2 = 0;
		for (int i=0; i< s.length(); i++)
		{
			char c = s.charAt(i);
			val = hm.get(c);
			if(i+1 < s.length())
			{
				char c2 = s.charAt(i+1);
				val2 = hm.get(c2);
				if(val2 <= val)
				{
					result += val;
				}
				else {
					result = result + val2- val;
					i++;
				}
			}
			else {
				result += val;
			}


		}
		System.out.println(result);
		return result;
	}

	public static void main(String args[])
	{
		String str = "MCMXCIV";
		Solution sol = new Solution();
		sol.romanToInt(str);
	}
}
