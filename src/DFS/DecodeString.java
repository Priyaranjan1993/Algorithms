package DFS;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		String result = "";
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		int len = s.length();
		int index = 0;
		while(index < len)
		{
			if(Character.isDigit(s.charAt(index)))
			{
				int count = 0;
				while(Character.isDigit(s.charAt(index)))
				{
					count = 10*count + (s.charAt(index) - '0');
					index ++;
				}
				numStack.push(count);
			}
			else if(s.charAt(index) == '['){
				strStack.push(result);
				result = "";
				index++;
			}
			else if(s.charAt(index) == ']'){
				StringBuilder t = new StringBuilder(strStack.pop());
				int times = numStack.pop();
				for(int k = 0; k < times; k++)
				{
					t.append(result);
				}
				result = t.toString();
				index++;
			}
			else {
				result += s.charAt(index);
				index ++;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		DecodeString d = new DecodeString();
		String s = "24[a]2[bc]";
		System.out.println(d.decodeString(s));
	}
}
