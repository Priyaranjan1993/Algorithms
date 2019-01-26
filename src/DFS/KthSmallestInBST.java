package DFS;

import java.util.Stack;

public class KthSmallestInBST {
	public int kthSmallest(TreeNode root, int k) {
		return inOrder(root, k);
	}

	private int inOrder(TreeNode root,int k) {
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
				if(--k == 0)
					return pop.val;
				System.out.println(pop.val);
				current = pop.right;
			}
		}
		return -1;
	}
}
