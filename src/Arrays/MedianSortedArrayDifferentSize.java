package Arrays;

public class MedianSortedArrayDifferentSize {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int length1 = 0;
		int length2 = 0;
		int maxLeftX = 0;
		int minLeftX = 0;
		int maxLeftY = 0;;
		int minLeftY = 0;
		double median = 0;

		double k = -1.0;
		if(nums1.length > nums2.length)
		{
			return findMedianSortedArrays(nums2, nums1);
		}

		if(nums1!=null)
		{
			length1 = nums1.length;
		}

		if(nums2!=null)
		{
			length2 = nums2.length;
		}

		if(length2 == 0 && length1 ==0)
		{
			return median;
		}

		if(length1 == 0)
		{
			double mid = 0;
			if(length2 % 2 == 0)
			{
				mid = (double)(nums2[(length2 - 1)/2] + nums2[(length2 - 1)/2 + 1]) / 2;
			}
			else {
				mid = nums2[length2/2];
			}
			return mid;
		}

		int start = 0;
		int end = length1;

		while(start <= end)
		{
			int partitionX = (start+end)/2;
			int partitionY = (length1 + length2 + 1)/2 - partitionX;

			maxLeftX = partitionX==0 ?Integer.MIN_VALUE : nums1[partitionX - 1];
			maxLeftY = partitionY==0 ?Integer.MIN_VALUE : nums2[partitionY - 1];

			if(partitionY == length2)
			{
				partitionY = partitionY -1;
			}
			minLeftX = partitionX==length1 ? Integer.MAX_VALUE : nums1[partitionX];
			minLeftY = partitionY==length1 ? Integer.MAX_VALUE : nums2[partitionY];

			if((maxLeftX <= minLeftY) && (maxLeftY <= minLeftX))
			{
				if((length1 + length2) % 2 == 0)
				{
					median = ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minLeftX, minLeftY))/2;
					return median;
				}
				else {
					median = (double)Math.max(maxLeftX, maxLeftY);
					return median;
				}
			}

			else if(maxLeftX > minLeftY)
			{
				end = partitionX - 1;
			}

			else {
				start = partitionX + 1;
			}
		}
		return median;
	}

	public static void main(String args[])
	{
		int [] n1 = new int[] {1,3};
		int [] n2 = new int[] {2};
		MedianSortedArrayDifferentSize m1 = new MedianSortedArrayDifferentSize();
		double x = m1.findMedianSortedArrays(n1, n2);
		System.out.println(x);
	}
}
