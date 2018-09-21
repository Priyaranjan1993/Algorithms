package Arrays;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int area = 0;
		int maxArea = 0;
		if(height.length ==0 || height.length < 2)
		{
			return area;
		}

		int left = 0;
		int right = height.length - 1;

		while(left < right)
		{
			area = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(area, maxArea);

			if(height[left] < height[right])
			{
				left++;
			}
			else {
				right--;
			}

		}
		return maxArea;

	}

	public static void main(String args[])
	{
		int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
		ContainerWithMostWater c = new ContainerWithMostWater();
		int a = c.maxArea(arr);
		System.out.println(a);
		
	}
}
