package Arrays;

public class MaxProductSubArray {

	public int maxProduct(int[] nums) {
		int result = nums[0];
		
		int max = result;
		int min = result;
		
		for(int i = 1; i < nums.length; i ++)
		{
			if(nums[i] < 0)
			{
				int temp = max;
				max = min;
				min = temp;
			}
			
			max = Math.max(nums[i], max*nums[i]);
			min = Math.min(nums[i], min * nums[i]);
			
			result = Math.max(max, result);
		}
		
		return result;
	}

	public static void main(String args[])
	{
		MaxProductSubArray m = new MaxProductSubArray();
		int[] nums = new int[] {2,3,-2,4};
		System.out.println(m.maxProduct(nums));
	}

}
