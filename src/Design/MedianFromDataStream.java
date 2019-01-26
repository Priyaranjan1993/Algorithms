package Design;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromDataStream {
	    private Queue<Long> small = new PriorityQueue(),
	                        large = new PriorityQueue();

	    public void addNum(int num) {
	        large.add((long) num);
	        small.add(-large.poll());
	        if (large.size() < small.size())
	            large.add(-small.poll());
	    }

	    public double findMedian() {
	        return large.size() > small.size()
	               ? large.peek()
	               : (large.peek() - small.peek()) / 2.0;
	    }
	
	public static void main(String args[]) {
		MedianFromDataStream m = new MedianFromDataStream();
		m.addNum(1);
		m.addNum(2);
		m.addNum(3);
		m.addNum(8);
		m.addNum(10);
		
		System.out.println(m.findMedian());
		
		
	}
}
