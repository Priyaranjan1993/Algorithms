package Arrays;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        String res="";
        for(int i = str.length ; i > 0 ; i--)
        {
        	res += str[i]+" ";
        }
        res.trim();
        return res;
    }
}
