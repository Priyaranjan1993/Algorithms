package Arrays;

public class TrappingRainWater {
	public int trap(int[] height) {
		if(height == null || height.length ==0)
			return 0;
		int[] left = new int[height.length]; 
		int[] right = new int[height.length];
		int max = 0;
		
		left[0] = height[0];
		max = height[0];
		
		for(int i = 1; i < height.length; i++)
		{
			if(height[i] < max)
			{
				left [i] = max;
			}
			else {
				max = height[i];
				left[i] = max;
			}
		}
		
		max = height[height.length - 1];
		right[height.length - 1] = max;
		
		for(int j = height.length - 2; j >=0 ; j--)
		{
			if(height[j] < max)
			{
				right [j] = max;
			}
			else {
				max = height[j];
				right[j] = max;
			}
		}
		
		max = 0;
		for(int k = 0; k < height.length; k++)
		{
			max = max + (Math.min(left[k], right[k]) - height[k]);
		}
		return max;
	}
	
	public static void main(String args[])
	{
		TrappingRainWater t = new TrappingRainWater();
		int height[] = new int[] {};
		System.out.println(t.trap(height));
	}
}
