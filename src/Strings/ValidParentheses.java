package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {


	private static boolean isParaValid(String para) {
		Map<Character,Character> map = new HashMap<>();
		Stack<Character> s = new Stack<>();
		map.put('[', ']');
		map.put('{', '}');
		map.put('(', ')');
		
		for(int i=0; i< para.length();i++)
		{
			Character ch = para.charAt(i);
			if(map.keySet().contains(ch))
			{
				s.push(ch);
			}
			else {
				if(!s.isEmpty() && map.get(s.peek()) == ch)
				{
					s.pop();
				}
				else {
					return false;
				}
			}
		}
		return s.isEmpty();
	}

	public static void main(String args[])
	{
		String para = "()";
		boolean b = isParaValid(para);
		System.out.println(b);
	}

}
