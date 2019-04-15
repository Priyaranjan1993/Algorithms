package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {
	Map<String, List<Integer>> map = new HashMap<>(); 
	public ShortestWordDistance2(String[] words) {
		for(int i = 0; i < words.length; i++)
		{
			if(map.containsKey(words[i]))
			{
				List<Integer> l = map.get(words[i]);
				l.add(i);
				map.put(words[i], l);
			}
			else {
				List<Integer> ls = new ArrayList<>();
				ls.add(i);
				map.put(words[i], ls);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> ls1 = map.get(word1);
		List<Integer> ls2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		for (int i = 0 , j = 0 ; i < ls1.size() && j < ls2.size();)
		{
			if(ls1.get(i) < ls2.get(j))
			{
				min = Math.min(min, ls2.get(j) - ls1.get(i));
				i++;
			}
			else {
				min = Math.min(min, ls1.get(i) - ls2.get(j));
				j++;
			}
		}
		return min;
	}
	
	public static void main(String args[]) {
		String[] str = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistance2 s = new ShortestWordDistance2(str);
		String word1 = "coding";
		String word2 = "practice";
		String word3 = "makes";
		String word4 = "coding";
		System.out.println(s.shortest(word1, word2));
		System.out.println(s.shortest(word3, word4));
		
	}
}
