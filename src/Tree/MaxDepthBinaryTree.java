package Tree;


/*  Definition for a binary tree node.*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class MaxDepthBinaryTree {
	TreeNode root;
	public int maxDepth(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right)+1;
	}
	public static void main(String args[])
	{
		MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);

		tree.root.right = new TreeNode(3);
		System.out.println(tree.maxDepth(tree.root));

	}
}
