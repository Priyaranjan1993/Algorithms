package Design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	Queue<Integer> queue;
	int size = 0;
	double sum = 0;
	
    public MovingAverage(int size) {
    	queue = new LinkedList<>();
    	this.size = size;
    }
    
    public double next(int val) {
    	if(queue.size() == size)
    	{
    		sum = sum - queue.poll();
    	}
    	queue.add(val);
    	sum = sum + val;
		return sum/queue.size();
        
    }
}
