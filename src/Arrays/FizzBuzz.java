package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<>();
        for(int i=0; i<n ; i++)
        {
        	int x = i+1;
            String s = Integer.toString(x);
            if(x%3 == 0 || x%5 == 0)
            	s ="";
            if(x%3 == 0)
            {
                s += "Fizz";
            }
            if(x%5 == 0)
            {
                s += "Buzz";
            }
            ls.add(s);
        }
        return ls;
    }
    
    public static void main(String args[]) {
		FizzBuzz f = new FizzBuzz();
		int n = 15;
		System.out.println(f.fizzBuzz(n));
	}
}
