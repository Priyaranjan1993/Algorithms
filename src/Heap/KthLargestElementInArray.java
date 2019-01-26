package Heap;

import java.util.Arrays;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
    	if(k < nums.length)
    	{
            Arrays.sort(nums);
            int result = (nums[nums.length - k]);
            return result;
    	}
    	else {
    		return -1;
    	}
    }
}
