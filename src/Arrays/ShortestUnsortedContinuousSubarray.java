package Arrays;

public class ShortestUnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {
		int length = 0;
		int i=0;
		int k=0;
		int start = 0;
		int end = nums != null ? nums.length - 1 : 0;

		if(nums == null)
		{
			return length;
		}

		if(nums.length == 2)
		{
			if(nums[0] > nums[1])
			{
				length = 2;
			}
		}

		if(nums.length > 2)
		{
			for (i=0; i<nums.length - 1; i++)
			{
				if(nums[i] > nums[i+1])
				{
					break;
				}
			}
			
			if(i == nums.length -1)
			{
				return 0;
			}

			for (k = nums.length - 1; k > 0; k--)
			{
				if(nums[k] < nums[k - 1])
				{
					break;
				}
			}

			/*start = start - 1;
			end = end + 1*/;
			int max = nums[i];
			int maxIndex = i;
			int min = nums[i];
			int minIndex = k;
			for(int y= i+1 ; y<=k; y++)
			{
				if(nums[y] > max)
				{
					max = nums[y];
					maxIndex = y;
				}

				if(nums[y] < min)
				{
					min = nums[y];
					minIndex = y;
				}
			}

			for ( int yy=0 ; yy< i; yy++)
			{
				if(nums[yy] > min)
				{
					i = yy;
				}
			}

			for ( int xx= nums.length - 1 ; xx>k; xx--)
			{
				if(nums[xx] < max)
				{
					k = xx;
				}
			}

			length = k -i + 1;

		}
		return length;
	}

	public static void main (String args[])
	{
		int[] arr = new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
		int  m = s.findUnsortedSubarray(arr);
		System.out.println(m);

	}
}
