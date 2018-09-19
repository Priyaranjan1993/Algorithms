package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i< nums.length; i++)
		{
			int index = Math.abs(nums[i]);
			
			if(nums[index-1] > 0)
			{
				nums[index-1] = - nums[index - 1];
			}
			else {
				arr.add(Math.abs(index));
			}
		}
		return arr;

	}
	public static void main(String args[])
	{
		int[] intArr = new int[] {4,3,2,7,8,2,3,1};
		ArrayList<Integer> list = new ArrayList<>();
		FindAllDuplicatesInAnArray arr = new FindAllDuplicatesInAnArray();
		list = (ArrayList<Integer>) arr.findDuplicates(intArr);
		for(int x : list)
		{
			System.out.println(x);
		}
	}
}
