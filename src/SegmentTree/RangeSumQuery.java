package SegmentTree;

class segmentTree
{
	int start;
	int end;
	int sum;
	segmentTree left;
	segmentTree right;

	public segmentTree(int start, int end) {
		this.start = start;
		this.end = end;
		this.sum = 0;
		this.left = null;
		this.right = null;
	}
}

public class RangeSumQuery {

	segmentTree root;

	public RangeSumQuery(int[] nums) {
		root = util(nums,0,nums.length - 1);
	}	

	private segmentTree util(int[] nums, int start, int end) {
		if(start > end)
		{
			return null;
		}
		else {			
			segmentTree s = new segmentTree(start, end);
			if(start == end)
			{
				s.sum = nums[start];
			}
			else{
				int mid = start + (end - start)/2;
				s.left = util(nums,start,mid);
				s.right = util(nums,mid + 1,end);
				s.sum = s.left.sum + s.right.sum;
			}
			return s;
		}

	}

	public void update(int i, int val) {
		updateUtil(root, i, val);
	}

	public void updateUtil(segmentTree root, int pos, int val)
	{
		if(root.left == root.right)
		{
			root.sum = val;
		}
		else {
			int mid = root.start + (root.end - root.start)/2;
			if(pos <= mid)
			{
				updateUtil(root.left, pos, val);
			}
			else {
				updateUtil(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRangeUtil(root,i,j);
	}

	public int sumRangeUtil(segmentTree root, int i, int j) {
		if(root.start == i && root.end == j)
		{
			return root.sum;
		}
		else {
			int mid = i + (j - i)/2;
			if(j < mid)
			{
				return sumRangeUtil(root.left, i, j);
			}
			else if(i >= mid)
			{
				return sumRangeUtil(root.right, i, j);
			}
			else {
				return sumRangeUtil(root.left,i , mid) + sumRangeUtil(root.right, mid + 1, j);
			}
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] {9,-8};
		RangeSumQuery r = new RangeSumQuery(nums); 
		//r.sumRange(0, 2);
		r.update(0, 3);
		r.sumRange(1, 1);
		r.sumRange(0, 1);
		r.update(1, -3);
		r.update(0, 1);
	}
}
