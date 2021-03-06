package DP;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) 
        	return true;
        s = s.toLowerCase();
        for(int i = 0, j = s.length()-1;i<j;i++,j--){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(s.charAt(i) != s.charAt(j)) 
            	return false;
        }
        return true;
    }

	public static void main(String args[]) {
		ValidPalindrome v = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(v.isPalindrome(s));
	}
}
