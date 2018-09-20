package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int closest = 0;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int diff =0;
		int sum = 0;

		for(int i=0; i < nums.length; i++)
		{
			int j = i+1;
			int k = nums.length - 1;

			while(j < k)
			{
				sum = nums[i] + nums[j] + nums[k];
				diff = Math.abs(target - sum);

				if(diff < min)
				{
					min = diff;
					closest = sum;
				}

				if(sum <target)
				{
					j++;
				}
				else {
					k--;
				}
			}
		}
		return closest;
	}

	public static void main(String args[])
	{
		ThreeSumClosest t = new ThreeSumClosest();
		int[] arr = new int[] {-1, 2, 1, -4};
		int sum = t.threeSumClosest(arr, 1);
		System.out.println(sum);
	}
}
