package Design;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromDataStream {
	
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
    	max.offer(num);
    	min.offer(max.poll());
    	if(max.size() < min.size())
    	{
    		max.offer(min.poll());
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
    	if(max.size() == min.size())
    	{
    		return (max.peek() + min.peek())/2.0;
    	}
    	else {
    		return max.peek();
    	}
    }
	
	public static void main(String args[]) {
		MedianFromDataStream m = new MedianFromDataStream();
		m.addNum(1);
		m.addNum(2);
		//m.addNum(3);
/*		m.addNum(8);
		m.addNum(10);*/
		
		System.out.println(m.findMedian());
		
		
	}
}
