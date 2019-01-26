package Graph;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianDataStream {
	PriorityQueue<Integer> maxHeap;//lower half
	PriorityQueue<Integer> minHeap;//higher half

	public MedianDataStream() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}

/*	// Adds a number into the data structure.
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(maxHeap.size()==minHeap.size()){
			return (double)(maxHeap.peek()+(minHeap.peek()))/2;
		}else{
			return maxHeap.peek();
		}
	}*/

		public void addNum(int num) {
		if(minHeap.size() == 0 || num < minHeap.peek())
		{
			minHeap.add(num);
		}
		else {
			maxHeap.add(num);
		}

		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ?maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ?minHeap : maxHeap;

		if(biggerHeap.size()- smallerHeap.size() >= 2)
		{
			smallerHeap.add(biggerHeap.poll());
		}
	}

	public double findMedian() {
		PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ?maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ?minHeap : maxHeap;

		if(biggerHeap.size() == smallerHeap.size())
		{
			System.out.println(((double)biggerHeap.peek()+ (double)smallerHeap.peek()) / 2);
			return ((double)biggerHeap.peek()+ (double)smallerHeap.peek()) / 2 ;
		}
		else {
			System.out.println(biggerHeap.peek());
			return biggerHeap.peek();
		}
	}

	public static void main(String args[])
	{
		MedianDataStream m = new MedianDataStream();
		m.addNum(1);
		m.addNum(2);
		m.findMedian();
		m.addNum(3);
		m.findMedian();
	}
}
