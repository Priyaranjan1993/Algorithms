package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//Airplane seat arrangement problem
public class Demo {
	public int solution(int N, String S) {
		String[] strings = S.split(" ");
		List<String> list = Arrays.asList(strings);
		int count = 0;
		Map< Integer,List<String>> hm =  
				new HashMap< Integer,List<String>>();
		
		for(String s : list)
		{
			char ss = s.charAt(0);
			int x = Character.getNumericValue(ss);
			if(hm.get(x) != null)
			{
				hm.get(x).add(s.substring(s.length() - 1));
			}
			else {
				List<String> ls = new ArrayList<>();
				ls.add(s.substring(s.length() - 1));
				hm.put(x, ls);
			}
		}
		
		Set<Entry<Integer, List<String>>> st = hm.entrySet();    
		  
	       for (Map.Entry<Integer, List<String>> me:st) 
	       { 
	    	   if(me.getKey() <=N)
	    	   {
	    		   if(!me.getValue().contains("A") && !me.getValue().contains("B") && !me.getValue().contains("C"))
	    		   {
	    			   count++;
	    		   }
	    		   if(!me.getValue().contains("H") && !me.getValue().contains("I") && !me.getValue().contains("J"))
	    		   {
	    			   count++;
	    		   }
	    		   if(!me.getValue().contains("E") && !me.getValue().contains("F"))
	    		   {
	    			   count++;
	    		   }
	    	   }
	       }
		System.out.println(count);
		return count;
	}

	public static void main(String args[])
	{
		Demo d = new Demo();
		d.solution(2, "1A 2F 1C");
	}
}
