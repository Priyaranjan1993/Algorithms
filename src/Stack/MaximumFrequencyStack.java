package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

	Map<Integer,Integer> freqMap;
	Map<Integer,Stack<Integer>> countMap;
	int frequency = 0;

	public MaximumFrequencyStack() {
		freqMap = new HashMap<>();
		countMap = new HashMap<>();
	}

	public void push(int x) {
		int count = freqMap.getOrDefault(x, 0) + 1;
		freqMap.put(x, count);
		frequency = Math.max(frequency, count);
		if(!countMap.containsKey(count))
		{
			countMap.put(count, new Stack<Integer>());
		}
		countMap.get(count).add(x);
	}

	public int pop() {
		int val = countMap.get(frequency).pop();
		freqMap.put(val, frequency - 1);
		if(countMap.get(frequency).size() == 0)
		{
			frequency--;
		}
		return val;
	}
	
	public static void main(String args[]) {
		MaximumFrequencyStack freq = new MaximumFrequencyStack();
		freq.push(4);
		freq.push(0);
		freq.push(9);
		freq.push(3);
		freq.push(4);
		freq.push(2);
		System.out.println(freq.pop());
		freq.push(6);
		System.out.println(freq.pop());
		freq.push(1);
		System.out.println(freq.pop());
		freq.push(1);
		System.out.println(freq.pop());
		freq.push(4);
		System.out.println(freq.pop());
		System.out.println(freq.pop());
		System.out.println(freq.pop());
		System.out.println(freq.pop());
		System.out.println(freq.pop());
		System.out.println(freq.pop());
	}
}
