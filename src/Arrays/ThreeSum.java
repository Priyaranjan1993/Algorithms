package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		ArrayList<List<Integer>> arr = new ArrayList<>();
		if(nums.length < 3 || nums == null)
		{
			return arr;
		}

		Arrays.sort(nums);

		for (int i =0 ; i <= nums.length -2; i++)
		{
			if(i ==0 || nums[i] > nums[i-1])
			{
				int j = i+1;
				int k = nums.length - 1;

				while(j<k)
				{
					if(nums[i] + nums[j] + nums[k] == 0)
					{
						ArrayList<Integer> arr2 = new ArrayList<>();
						arr2.add(nums[i]);
						arr2.add(nums[j]);
						arr2.add(nums[k]);
						arr.add(arr2);

						j++;
						k--;

						while((j < k) && nums[j] == nums[j-1])
						{
							j++;
						}

						while((j < k) && nums[k] == nums[k+1])
						{
							k--;
						}
					}

					else if(nums[i] + nums[j] + nums[k] < 0)
					{
						j++;
					}
					else {
						k--;
					}
				}
			}
		}

		return arr;

	}

	public static void main(String args[])
	{
		ThreeSum t = new ThreeSum();
		ArrayList<List<Integer>> arr3 = new ArrayList<>();
		int[] x = new int[] {-1, 0, 1, 2, -1, -4};
		arr3 = (ArrayList<List<Integer>>) t.threeSum(x);

		for(List<Integer> x1 : arr3)
		{
		
				for(int y : x1)
				{
					System.out.println(y);
				}
				
				System.out.println("             ");
		}
	}
}
