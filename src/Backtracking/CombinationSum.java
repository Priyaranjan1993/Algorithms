package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
	    if(candidates == null || candidates.length == 0) return result;
	 
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	 
	    combinationSum(candidates, target, 0, current, result);
	 
	    return result;
	}
	 
	public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
	   if(target == 0){
	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
	       result.add(temp);
	       return;
	   }
	 
	   for(int i=j; i<candidates.length; i++){
	       if(target < candidates[i]) 
	            return;
	 
	       curr.add(candidates[i]);
	       combinationSum(candidates, target - candidates[i], i, curr, result);
	       curr.remove(curr.size()-1); 
	   }
	}

	public static void main(String args[])
	{
		CombinationSum c = new CombinationSum();
		int[] arr = new int[] {2,3,6,7};
		int target = 7;
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		ls = c.combinationSum(arr,target);
		for(List<Integer> l : ls)
		{
			System.out.println(l);
		}
	}
}
