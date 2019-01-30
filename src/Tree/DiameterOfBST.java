package Tree;

public class DiameterOfBST {
	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		diameterOfBinaryTreeUtil(root);
		return max;
	}

	private int diameterOfBinaryTreeUtil(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = diameterOfBinaryTreeUtil(root.left);
		int right = diameterOfBinaryTreeUtil(root.right);
		max = Math.max(max, left+right);
		return Math.max(left , right ) + 1;
	}
}
