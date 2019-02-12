package Design;

public class HitCounter {
    /** Initialize your data structure here. */
	int[] hits;
	int[] times;
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(times[index] != timestamp)
        {
        	times[index] = timestamp;
        	hits[index] = 1;
        }
        else{
        	hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int count = 0;
        for(int i=0 ; i< 300; i++)
        {
        	if(timestamp - times[i] < 300)
        	{
        		count = count + hits[i];
        	}
        }
        return count;
    }
}
