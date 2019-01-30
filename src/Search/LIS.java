package Search;

public class LIS {


	public int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size) ++size;
		}
		return size;
	}

	public static void main(String args[])
	{
		LIS demo = new LIS();
		int[]nums = new int[] {9,1,3,7,5,6,20};
		int ans = demo.lengthOfLIS(nums);
		System.out.println(ans);
	}
}
