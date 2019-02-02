package Strings;

public class ValidParenthesesString {
	private Boolean[][] res;
	public boolean checkValidString(String s) {
		int i = 0;
		int count = 0;
		res = new Boolean [s.length() + 1][s.length() + 1];
		return check(s,i,count);
	}

	private boolean check(String s, int start, int count) {
		if(count < 0)
			return false;
		int y = count;
		if(res[start][y] != null)
		{
			return res[start][y];
		}
		for(int j = start ; j < s.length(); j++)
		{
			if(s.charAt(j) == '(')
			{
				count++;
			}
			else if(s.charAt(j) == ')')
			{
				if(count <= 0)
					return false;
				count--;
			}
			else {
				res[start][y] = check(s, j+1, count+1) || check(s, j+1, count-1) || check(s, j+1, count);
				return res[start][y];
			}

		}
		res[start][y] = count == 0;
		return res[start][y];
	}

	public static void main(String args[]) {
		ValidParenthesesString v = new ValidParenthesesString();
		String s = "(*)";
		System.out.println(v.checkValidString(s));
	}
}
