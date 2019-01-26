package DFS;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class sortedArrToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root;
		root = sortedArrayToBST(nums,0,nums.length-1);
		return root;
	}

	private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		TreeNode root = null;
		if(start > end)
		{
			return null;
		}
		int mid = start + (end - start)/2;
		root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;
	}
	private void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while(!stack.isEmpty() || current != null)
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else {
				TreeNode pop = stack.pop();
				System.out.println(pop.val);
				current = pop.right;
			}
		}
	}

	public static void main(String[] args)
	{
		sortedArrToBST s = new sortedArrToBST();
		int[] nums = new int[] {-10,-3,0,5,9};
		s.inOrder(s.sortedArrayToBST(nums));
	}

}
