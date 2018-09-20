package Arrays;

public class ProductsOfArrayExceptSelf1 {
	public int[] productExceptSelf(int[] nums) {
		
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] result = new int[nums.length];
		
		if(nums.length == 0)
		{
			return result;
		}

		left[0] = 1;
		right[nums.length - 1] = 1;

		for (int i=1; i<nums.length; i++)
		{
			left[i] = left[i-1] * nums[i-1];
		}

		for(int k=nums.length -2; k>=0; k--)
		{
			right[k] = right[k+1] * nums[k + 1];
		}

		for(int m=0; m< nums.length ; m++)
		{
			result[m] = left[m] * right [m];
		}
		return result;

	}

	public static void main(String args[])
	{
		ProductsOfArrayExceptSelf1 p = new ProductsOfArrayExceptSelf1();
		int[] num = new int[] {1,2,3,4};
		int[] resultNum = p.productExceptSelf(num);
		for (int x : resultNum)
		{
			System.out.println(x);
		}
	}
}
