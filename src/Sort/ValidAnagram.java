package Sort;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length())
    		return false;
    	Map<Character, Integer> map = new HashMap<>();
    	for(Character c : s.toCharArray())
    	{
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	for(Character c : t.toCharArray())
    	{
    		if(map.get(c) == null || map.get(c) == 0)
    		{
    			return false;
    		}
    		else {
    			map.put(c, map.get(c) - 1);
    		}
    	}
		return true;
    }
    
    public static void main(String args[])
    {
    	ValidAnagram v = new ValidAnagram();
    	String s = "anagram&^%";
    	String t = "nagaram%^&";
    	System.out.println(v.isAnagram(s, t));
    }
}
