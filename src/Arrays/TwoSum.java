package Arrays;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length<2)
		{
			return new int[] {0,0};
		}
		else {
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i< nums.length; i++)
			{
				if(map.containsKey(nums[i]))
				{
					return new int[] {i,map.get(nums[i])};
				}
				else {
					map.put(target - nums[i], i);
				}
			}

		}
		return nums;

	}

	public static void main(String args[])
	{
		int[] arr = new int[] {2, 7, 11, 15};
		int target = 9;
		TwoSum t = new TwoSum();
		int[] x = t.twoSum(arr, target);
		for(int k : x)
		{
			System.out.println(k);
		}
	}
}
