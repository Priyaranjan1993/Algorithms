package Arrays;

public class CountingBits {

	int[] result;
	public int[] countBits(int num) {
		result = new int[num+1];
		for(int i=0; i<=num; i++)
		{
			result[i] = countForEachNum(i);
		}
		return result;
	}

	private int countForEachNum(int i) {
		int count = 0;

		while(i != 0)
		{
			if(i%2 == 1)
			{
				count++;
			}
			i = i/2;
		}
		return count;
	}

	public static void main(String args[])
	{
		CountingBits c = new CountingBits();
		c.countBits(5);
		for(int x : c.result)
		{
			System.out.println(x);
		}
	}

}
