package DFS;

public class isSymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetricUtil(root.left,root.right);
	}

	private boolean isSymmetricUtil(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		if(left.val != right.val)
			return false;

		if(!isSymmetricUtil(left.left,right.right))
			return false;
		if(!isSymmetricUtil(left.right,right.left))
			return false;
		return true;
	}
}
