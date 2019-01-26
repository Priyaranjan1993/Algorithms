package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int low = 0;
		int high = arr.length - k;

		while(low < high)
		{
			int mid = low + (high-low)/2;
			if(x - arr[mid] > arr[mid + k] - x)
			{
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		List<Integer> ls = new ArrayList<>();

		for(int i = low ; i < low+ k; i++)
		{
			ls.add(arr[i]);
		}
		return ls;
	}
}
