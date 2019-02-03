package DP;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
        	return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }
    
    public static void main(String args[]) {
		PalindromeNumber v = new PalindromeNumber();
		int x = 121;
		boolean a = v.isPalindrome(x);
		System.out.println(a);
	}
}
