package Search;

public class DuplicateNoInConstantArray {

    public int findDuplicate(int[] nums) {
    	int slow = nums[0];
    	int fast = nums[nums[0]];
    	
    	while(slow != fast)
    	{
    		slow = nums[slow];
    		fast = nums[nums[fast]];
    	}
    	fast = 0;
    	
    	while(fast != slow)
    	{
    		slow = nums[slow];
    		fast = nums[fast];
    	}
    	return slow;
    }
    
	public static void main(String args[])
	{
		int[] arr = new int[]{2,5,9,6,9,3,8,9,7,1};
		DuplicateNoInConstantArray s = new DuplicateNoInConstantArray();
		int x = s.findDuplicate(arr);
		System.out.println(x);
	}
    
}
