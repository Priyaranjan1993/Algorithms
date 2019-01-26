package Backtracking;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
      
    	List<List<Integer>> result = new ArrayList<>();
    	permuteUtil(result, new ArrayList<Integer>(),nums);
    	return result;
    	
    }
	
	private void permuteUtil(List<List<Integer>> result, ArrayList<Integer> arrayList, int[] nums) {
		if(arrayList.size() == nums.length)
		{
			result.add(new ArrayList<>(arrayList));
		}
		else {
			for(int i = 0; i < nums.length; i++)
			{
				if(arrayList.contains(nums[i]))
				{
					continue;
				}
				else {
					arrayList.add(nums[i]);
					permuteUtil(result, arrayList, nums);
					arrayList.remove(arrayList.size() - 1);
				}
			}
		}
	}

	public static void main(String args[])
	{
		Permutations p = new Permutations();
		int[] arr = new int[] {1,2,3};
		List<List<Integer>> ls = new ArrayList<>();
		ls = p.permute(arr);
		for(List<Integer> l : ls)
		{
			System.out.println(l);
		}
	}
}
