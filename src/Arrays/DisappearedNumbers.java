package Arrays;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {

		for(int i=0; i <nums.length; i++)
		{
			int index = Math.abs(nums[i]) - 1;
			if(nums[index] > 0)
			{
				nums[index] = -nums[index];
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();

		for(int m=0; m < nums.length; m++)
		{
			if(nums[m] > 0)
			{
				arr.add(m+1);
			}
		}
		return arr;
	}

	public static void main(String args[])
	{
		ArrayList<Integer> arr2 = new ArrayList<>();
		int[] a = new int [] {4,3,2,7,8,2,3,1};
		DisappearedNumbers d = new DisappearedNumbers();
		arr2 = (ArrayList<Integer>) d.findDisappearedNumbers(a);
		
		for(int k : arr2)
		{
			System.out.println(k);
		}
	}
}
