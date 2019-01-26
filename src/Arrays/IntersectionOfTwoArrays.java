package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set = new HashSet<>();
    	Arrays.sort(nums2);
    	for(int num : nums1)
    	{
    		if(binarySearch(nums2,num)) {
    			set.add(num);
    		}
    	}
    	int[] result = new int[set.size()];
    	int i = 0;
    	for(int x : set)
    	{
    		result[i++] = x;
    	}
		return result;
        
    }

	private boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while(low <= high)
		{
			int mid = low + (high-low)/2;
			if(target == nums[mid])
				return true;
			if(target > nums[mid])
			{
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		IntersectionOfTwoArrays inter = new IntersectionOfTwoArrays();
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {1};
		int[] result = inter.intersection(nums1, nums2);
		for(int x : result)
		{
			System.out.println(x);
		}
	}
}
