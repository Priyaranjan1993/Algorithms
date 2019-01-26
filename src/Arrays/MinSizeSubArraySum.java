package Arrays;

public class MinSizeSubArraySum {
	public int minSubArrayLen(int s, int[] a) {
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;

		if(a.length == 0 || a == null)
		{
			return 0;
		}

		while ( j < a.length)
		{
			sum  = sum + a[j++];
			while(sum >= s)
			{
				min = Math.min( min, j - i);
				sum = sum - a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String args[])
	{
		MinSizeSubArraySum m = new MinSizeSubArraySum();
		int[] nums = new int[] {2,3,1,2,4,3};
		int  k = 7;
		System.out.println(m.minSubArrayLen(k, nums));
	}
}
