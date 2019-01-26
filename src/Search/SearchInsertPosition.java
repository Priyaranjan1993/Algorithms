package Search;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high)
        {
        	int mid = low + (high - low)/2;
        	if(nums[mid] == target)
        	{
        		return mid;
        	}
        	
        	if(target < nums[mid])
        	{
        		high = mid -1;
        	}
        	else {
        		low = mid + 1;
        	}
        }
        return low;
    }
    
	public static void main(String args[])
	{
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = new int[] {1,3,5,6};
		int target = 2;
		System.out.println(s.searchInsert(nums, target));
	
	}
}
