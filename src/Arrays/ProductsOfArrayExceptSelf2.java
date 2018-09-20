package Arrays;

public class ProductsOfArrayExceptSelf2 {
	public int[] productExceptSelf(int[] nums) {

		int[] result = new int[nums.length];
		
		if(nums.length == 0)
		{
			return result;
		}

		result[0] = 1;
		int right =1;

		for (int i=1; i<nums.length; i++)
		{
			result[i] = result[i-1] * nums[i-1];
		}

		for(int k=nums.length - 1; k>=0; k--)
		{
			result[k] = result[k] * right;
			right = right * nums[k];
		}

		return result;

	}

	public static void main(String args[])
	{
		ProductsOfArrayExceptSelf2 p = new ProductsOfArrayExceptSelf2();
		int[] num = new int[] {1,2,3,4};
		int[] resultNum = p.productExceptSelf(num);
		for (int x : resultNum)
		{
			System.out.println(x);
		}
	}
}
