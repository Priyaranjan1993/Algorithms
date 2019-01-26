package Search;

import java.util.PriorityQueue;

public class MinInRotatedSortedArray {
	/*
	 * Time complexity is  nlogn which is bad
	PriorityQueue<Integer> pr = new PriorityQueue<>();
	public int findMin(int[] nums) {
		for(int i=0; i< nums.length; i++)
		{
			pr.offer(nums[i]);
		}
		return pr.poll();
	}
	*/
	
	public int findMin(int[] nums) {
		int l = 0;
		int h = nums.length-1;
		int mid = 0;
		while(l <= h)
		{
			mid = l + (h - l)/2;
			
			if(nums[mid] >= nums[h])
			{
				l = mid + 1;
			}
			else {
				h = mid;
			}
		}
		return nums[mid];
	}
	
	public static void main(String args[])
	{
		int[] arr = new int[] {3,4,5,1,2};
		MinInRotatedSortedArray min = new MinInRotatedSortedArray();
		int x = min.findMin(arr);
		System.out.println(x);
	}
}
