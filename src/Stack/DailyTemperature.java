package Stack;

import java.util.Stack;


public class DailyTemperature {

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[temperatures.length];
		for(int i = 0; i< temperatures.length; i++)
		{
			while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
			{
				int pop = stack.pop();
				int val = i - pop;
				arr[pop] = val;
			}
			stack.push(i);
		}
		return arr;
	}
	
	public static void main(String args[])
	{
		DailyTemperature d = new DailyTemperature();
		int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		int[] s = d.dailyTemperatures(temp);
		for(int x : s)
		{
			System.out.println(x);
		}
	}
}
