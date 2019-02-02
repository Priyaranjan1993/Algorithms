
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for(int i = 0; i < n ; i ++)
		{
			while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
			{
				swap(nums,nums[i] - 1,i);
			}
		}

		for(int j =0; j < n; j++)
		{
			if(nums[j] != j+1)
				return j+1;
		}
		return n+1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[])
	{
		FirstMissingPositive f = new FirstMissingPositive();
		int[] arr = new int[] {3,4,-1,1};
		int x = f.firstMissingPositive(arr);
		System.out.println(x);
	}
}
