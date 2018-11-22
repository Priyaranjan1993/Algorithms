package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.*/

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		if(paragraph.length() ==0)
		{
			return null;
		}
		String[] par = paragraph.replaceAll("!?',;.", "").toLowerCase().split("\\s*(=>|,|\\s)\\s*");
		Map<String, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		String res = "";
		for(String s : par)
		{
			if(map.get(s) == null)
			{
				map.put(s, 1);
			}
			else {
				map.put(s, map.get(s) + 1);
			}
		}
		List<String> al = (List<String>) Arrays.asList(banned);
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			if(!al.contains(entry.getKey()))
			{
				if(entry.getValue() > max)
				{
					max = entry.getValue();
					res = entry.getKey();
				}
			}
		}
		return res;
	}
	
	public static void main(String args[])
	{
		MostCommonWord m = new MostCommonWord();
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"};
		String res = m.mostCommonWord(paragraph, banned);
		System.out.println(res);
	}
}
