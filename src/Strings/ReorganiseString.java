package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseString {
	public String reorganizeString(String S) {
		
		if(S == null || S.length() == 0)
		{
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
		for(Character s : S.toCharArray())
		{
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());

		for(Map.Entry<Character, Integer> entry : map.entrySet())
		{
			pq.offer(entry);
		}

		StringBuffer sb = new StringBuffer();
		while(!pq.isEmpty())
		{
			Map.Entry<Character, Integer> c1 = pq.poll();

			if(sb.length() == 0 || c1.getKey() != sb.charAt(sb.length() - 1))
			{
				sb.append(c1.getKey());
				c1.setValue(c1.getValue() - 1);

				if(c1.getValue() >0)
				{
					pq.offer(c1);
				}
			}
			else {

				Map.Entry<Character, Integer> c2 = pq.poll();
				if(c2 == null)
				{
					return "";
				}

				sb.append(c2.getKey());
				c2.setValue(c2.getValue() - 1);


				if(c2.getValue() >0)
				{
					pq.offer(c2);
				}

				pq.offer(c1);
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[])
	{
		ReorganiseString r = new ReorganiseString();
		String s = r.reorganizeString("aaab");
		System.out.println(s);
	}
}
