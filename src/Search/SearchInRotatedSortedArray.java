package Search;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if(nums.length == 0)
		{
			return -1;
		}
/*		if(nums[0] == target)
		{
			return 0;
		}*/
		return pivotBinarySearch(nums,0,nums.length-1,target);
	}

	public int pivotBinarySearch(int[] arr, int start, int end,int key)
	{
		int pivot = findPivot(arr,start,end);
		if(pivot == -1)
		{
			return -1;
		}

		if((key >= arr[pivot]) && (key <= arr[end]))
		{
			return binarySearch(arr,pivot,end,key);
		}
		else {
			return binarySearch(arr,start,pivot - 1, key);
		}		
	}

	private int binarySearch(int[] arr, int start, int end, int key) {
		while(start <= end)
		{
			int mid  = start + (end-start)/2;

			if(arr[mid] == key)
			{
				return mid;
			}

			if(key <= arr[mid])
			{
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int findPivot(int[] arr, int start, int end)
	{
		if(start > end)
		{
			return -1;
		}

		int mid = start + (end - start)/2;

		if(mid + 1 <= arr.length -1)
		{
			if(arr[mid] > arr [mid+1])
			{
				return mid + 1;
			}
			else {
				if(arr[start] <= arr[mid])
				{
					return findPivot(arr, mid + 1, end);
				}
				else {
					return findPivot(arr, start, mid - 1);
				}
			}
		}
		else {
			return mid;
		}

	}

	public static void main(String args[])
	{
		int[] arr = new int[] {4,5,6,7,0,1,2};
		int key = 0;
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int result = s.search(arr, key);
		System.out.println(result);
	}
}
