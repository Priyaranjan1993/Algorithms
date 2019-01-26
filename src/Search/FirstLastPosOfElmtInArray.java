package Search;

public class FirstLastPosOfElmtInArray {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirstPos(nums,0,nums.length-1,target);
		result[1] = findLastPos(nums,0,nums.length-1,target);
		System.out.println(result[0]+" "+result[1]);
		return result;
	}

	private int findFirstPos(int[] nums, int i, int j, int target) {
		while(i <= j)
		{
			int mid = i + (j-i)/2;

			if(target == nums[mid] && (mid == 0 || nums[mid - 1] < target))
			{
				return mid;
			}

			if(target > nums[mid])
			{
				i = mid + 1;
			}
			else {
				j = mid -1;
			}
		}
		return -1;
	}

	private int findLastPos(int[] nums, int i, int j, int target) {
		while(i <= j)
		{
			int mid = i + (j-i)/2;

			if(target == nums[mid] && ( mid == nums.length -1 || nums[mid + 1] > target))
			{
				return mid;
			}

			if(target >= nums[mid])
			{
				i = mid + 1;
			}
			else {
				j = mid -1;
			}
		}
		return -1;
	}

	public static void main(String args[])
	{
		FirstLastPosOfElmtInArray demo = new FirstLastPosOfElmtInArray();
		int[] nums = new int[] {2,2};
		int target = 2;
		demo.searchRange(nums, target);
	}

}
