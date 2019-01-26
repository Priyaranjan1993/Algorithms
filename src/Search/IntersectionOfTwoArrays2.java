package Search;

import java.util.*;

public class IntersectionOfTwoArrays2 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> ls = new ArrayList<>();

		for(int num : nums1)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for(int i : nums2)
		{
			if(map.containsKey(i) && map.get(i) > 0)
			{
				ls.add(i);
				map.put(i, map.get(i) - 1);
			}
		}

		int[] res = new int[ls.size()];
		int i = 0;
		for(int x : ls)
		{
			res[i++] = x;
		}
		return res;
	}

	public static void main(String args[])
	{
		IntersectionOfTwoArrays2 inter = new IntersectionOfTwoArrays2();
		int[] nums1 = new int[] {4,9,5};
		int[] nums2 = new int[] {9,4,9,8,4};
		int[] result = inter.intersect(nums1, nums2);
		for(int x : result)
		{
			System.out.println(x);
		}
	}
}
