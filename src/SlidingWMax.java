import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWMax {
/*    public int[] maxSlidingWindow(int[] nums, int k) {
    	int[] maxs = new int[nums.length - k + 1];
    	for (int i = 0; i < maxs.length; i++) {
    	  int temp = nums[i];
    	  for (int j = 1; j < k; j++) {
    	    if (nums[i + j] > temp)  // Can flip inequality to get minimum
    	      temp = nums[i + j];
    	  }
    	  maxs[i] = temp;
    	}
		return maxs;
    }*/
    
	public int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums==null||nums.length==0)
	        return new int[0];
	 
	    int[] result = new int[nums.length-k+1];
	 
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	 
	        deque.offer(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}
    public static void main(String args[])
    {
    	SlidingWMax s = new SlidingWMax();
    	int[] nums = {31,41,59,26,53,58,97};
    	int k = 3;
    	int[] res = s.maxSlidingWindow(nums, k);
    	for(int r : res)
    	{
    		System.out.println(r);
    	}
    }
}
