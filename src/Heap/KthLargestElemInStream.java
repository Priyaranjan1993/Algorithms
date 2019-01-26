package Heap;

import java.util.PriorityQueue;

public class KthLargestElemInStream {
	final PriorityQueue<Integer> q;
	final int k;

	public KthLargestElemInStream(int k, int[] a) {
		this.k = k;
		q = new PriorityQueue<>(k);
		for (int n : a)
			add(n);
	}

	public int add(int n) {
		if (q.size() < k)
			q.offer(n);
		else if (q.peek() < n) {
			q.poll();
			q.offer(n);
		}
		return q.peek();
	}

	public static void main(String args[]) {
		int k = 3;
		int[] arr = new int[] {4,5,8};
		KthLargestElemInStream kthLargest = new KthLargestElemInStream(k, arr);
		int res = kthLargest.add(2);   // returns 4
/*		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		kthLargest.add(9);   // returns 8
*/		//int res = kthLargest.add(4);   // returns 8
		System.out.println(res);
	}
}
