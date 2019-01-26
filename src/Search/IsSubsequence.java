package Search;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		char[] ch = s.toCharArray();
		int index = -1;
		for(char c : ch)
		{
			index = t.indexOf(c, index+1);
			if(index == -1)
				return false;
		}
		return true;
	}

}
