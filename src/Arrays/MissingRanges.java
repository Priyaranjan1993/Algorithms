package Arrays;

import java.util.ArrayList;
import java.util.List;


public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        if(nums.length == 0) {
            res.add(generateRange(lower, upper));
            return res;
        }
        
        if(upper < lower)
        	return res;
        
        if(lower == Integer.MAX_VALUE) {
            return res;
        }
        
        int next = lower;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < next)
                continue;
            
            if(nums[i] == next) {
                next = next+1;
                continue;
            }
            res.add(generateRange(next, Math.min(nums[i]-1,upper)));
            
            //Overflow : no need to update and check, just return
            if(nums[i] == upper || upper < nums[i]) {
                return res;
            }
            next = nums[i]+1;
        } 
        
        //check if upper didn't overlap in the nums array
        if(next <= upper)
            res.add(generateRange(next, upper));
        
        return res;
    }
    
    private String generateRange(long start, long end) {
        if(start == end)
            return ""+start;
        else
            return start+"->"+end;
    }
    
    public static void main(String[] args) {
    	MissingRanges m = new MissingRanges();
    	int[] nums = new int[] {0, 1, 3, 50, 75};
    	int lower = 10;
    	int upper = -99;
    	System.out.println(m.findMissingRanges(nums, lower, upper));
	}
}
