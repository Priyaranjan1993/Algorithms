package Arrays;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if(numbers.length <2 || numbers == null)
		{
			return result;
		}

		int left = 0;
		int right = numbers.length - 1;

		while(left < right)
		{
			int sum = numbers[left] + numbers[right];
			if(sum == target)
			{
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			}
			if(sum > target)
			{
				right --;
			}
			else {
				left ++ ;
			}
		}
		return numbers;
	}
	
	public static void main(String args[])
	{
		TwoSum2 t = new TwoSum2();
		int[] numbers = new int[] {-1,0};
		int target = -1;
		t.twoSum(numbers, target);
	}
}
