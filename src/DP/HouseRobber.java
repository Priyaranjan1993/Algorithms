package DP;

import java.util.Arrays;

public class HouseRobber {
	int[] store;
	public int rob(int[] nums) {
		int length = nums.length;
		store = new int[length + 1];
		Arrays.fill(store, -1);
		int result = helper(nums,length - 1);
		return result;
	}

	private int helper(int[] nums, int i) {
		if(i < 0 )
		{
			return 0;
		}
		if(store[i] >= 0)
		{
			return store[i];
		}

		int res = Math.max(nums[i] + helper(nums, i-2), helper(nums,i-1));
		store[i] = res;
		return res;
	}
	
	public static void main(String args[]) {
		HouseRobber h = new HouseRobber();
		int[] nums = new int[] {1,2,3,1};
		System.out.println(h.rob(nums));
	}
}
