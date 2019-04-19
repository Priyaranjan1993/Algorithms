package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
    	List<List<Integer>> res = new ArrayList<>();
        helper(2,n,new ArrayList<>(),res);
        return res;
    }
    
    public void helper(int factor, int n, List<Integer> ls, List<List<Integer>> res)
    {
    	for(int i = factor; i*i <= n; i++)
    	{
    		if(n%i == 0)
    		{
    			ls.add(i);
    			ls.add(n/i);
    			res.add(new LinkedList<Integer>(ls));
    			ls.remove(ls.size() - 1);
    			helper(i, n/i, ls, res);
    			ls.remove(ls.size() - 1);
    		}
    	}
    }

	
	public static void main(String args[])
	{
		FactorCombinations f = new FactorCombinations();
		 List<List<Integer>> res = f.getFactors(12);
		 System.out.println("************************************");
		 for(List<Integer> ls : res)
		 {
			 for(int i=0; i< ls.size(); i++)
			 {
				 System.out.println(ls.get(i));
			 }
			 System.out.println("***");
			
		 }
	}
}
