package Arrays;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int count = 0;
		int length = nums.length;

		for(int i=0; i<length; i++)
		{
			if(nums[i] != 0)
			{
				nums[count] = nums[i];
				count++;
			}
		}

		while(count < length)
		{
			nums[count] = 0;
			count++;
		}
	}

	public static void main(String args[])
	{
		int [] num = new int[] {0,1,0,3,12};
		MoveZeroes m = new MoveZeroes();
		m.moveZeroes(num);
		for(int x : num)
		{
			System.out.println(x);
		}
	}
}
