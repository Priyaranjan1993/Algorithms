package Tree;

public class BalancedBinaryTree {
	TreeNode root;
	public boolean isBalanced(TreeNode root) {
		int x = isBalancedUtil(root);
		if(x == -1)
		{
			return false;
		}
		return true;
	}
	public int isBalancedUtil(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		int left = isBalancedUtil(root.left);
		int right = isBalancedUtil(root.right);
		
		if(left == -1 || right == -1)
		{
			return -1;
		}
		
		if(Math.abs(left - right) > 1)
		{
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
	public static void main(String args[])
	{
		BalancedBinaryTree tree = new BalancedBinaryTree();

	}
}
