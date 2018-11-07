package Backtracking;

import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

	public static List<String> generateParenthesis(int n) {

		String s = paraHelper("",n,0);
		String[] result = s.split(",");
		List<String> ls;
		ls = Arrays.asList(result);
		return ls;
	}

	public static String paraHelper(String string, int available, int unclosed) {
		if(available == 0)
		{
			for(int i=0; i<unclosed;i++)
			{
				string = string+')';
			}
		}
		else if(unclosed == 0)
		{
			string = paraHelper(string+'(', available - 1, unclosed + 1);
		}
		else {
			string = paraHelper(string+'(', available - 1, unclosed + 1) +","+ paraHelper(string+')', available, unclosed - 1);
		}
		return string;
	}

	public static void main(String args[])
	{
		List<String> ls;
		ls = generateParenthesis(3);
		for(String s : ls)
		{
			System.out.println(s);
		}
	}
}
