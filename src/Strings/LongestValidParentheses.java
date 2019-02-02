package Strings;
import java.util.*;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		char[] ch = s.toCharArray();
		int longest = 0;
		int l = s.length();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] == '(')
			{
				stack.push(i);
			}
			else {
				if(!stack.isEmpty() && ch[stack.peek()] == '(')
				{
					stack.pop();
				}
				else {
					stack.push(i);
				}
			}
		}
		int a = l;
		int b = 0;
		if(stack.isEmpty())
		{
			return l;
		}
		else {
			while(!stack.isEmpty())
			{
				b = stack.pop();
				longest = Math.max(longest, a-b-1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest;
	}
	
	public static void main(String args[])
	{
		LongestValidParentheses l = new LongestValidParentheses();
		String s = "()()((()";
		System.out.println(l.longestValidParentheses(s));
		
	}
}
