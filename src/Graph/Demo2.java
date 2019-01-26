package Graph;

import java.util.Collections;
import java.util.PriorityQueue;

public class Demo2 {

	public int findKthLargest(int[] nums, int k) {
		//PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i: nums){
			q.offer(i);
			System.out.println(q);
			if(q.size()>k){
				q.poll();
			}
		}


		return q.peek();
	}

	public static void main(String args[])
	{
		int k = 2;
		int[] arr = {4,5,8,2};
		Demo2 kthLargest = new Demo2();
		int val = kthLargest.findKthLargest(arr, k);
		System.out.println(val);
	}
}
