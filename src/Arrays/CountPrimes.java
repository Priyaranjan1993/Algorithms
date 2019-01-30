package Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        
        boolean[] arr = new boolean[n];
        
        for(int i =2; i < n; i++)
        {
        	if(arr[i] == false)
        	{
        		count ++;
        		for(int j = 2 ; i*j < n ;j++)
        		{
        			arr[i*j] = true;
        		}
        	}
        }
        return count;
    }
    
    public static void main(String args[])
    {
    	CountPrimes c = new CountPrimes();
    	int n = 10;
    	System.out.println(c.countPrimes(n));
    }
}
