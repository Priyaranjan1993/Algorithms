package Heap;

import java.util.HashMap;
import java.util.*;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> {
			return a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue();
		});

		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			pq.offer(entry);
			if(pq.size() > k)
			{
				pq.poll();
			}
		}

		while(!pq.isEmpty())
		{
			result.add(pq.poll().getKey());
		}
		return result;
	}

	public static void main(String args[])
	{
		TopKFrequentElements t = new TopKFrequentElements();
		int[] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		System.out.println(t.topKFrequent(nums, k));
	}
}
