package DFS;

import java.util.Stack;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return inOrder(root);
	}

	private boolean inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
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
				if(pre != null && pre.val >= pop.val)
				{
					return false;
				}
				pre = pop;
				System.out.println(pop.val);
				current = pop.right;
			}
		}
		return true;
	}
}
