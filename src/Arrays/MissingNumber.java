package Arrays;

public class MissingNumber {

	public int missingNumber(int[] nums) {
		int res = nums.length;
		for(int i=0; i<nums.length; i++){
			res = res ^ i ^ nums[i]; // a^b^b = a
		}
		return res;
	}
	
	public static void main(String args[])
	{
		MissingNumber m = new MissingNumber();
		int[] nums = new int [] {1,4,0,2};
		int x = m.missingNumber(nums);
		System.out.println(7^4);
		System.out.println(x);
	}
}
