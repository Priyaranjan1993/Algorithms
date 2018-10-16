package Tree;

public class SymmetricTree {

	TreeNode root;
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
		{
			return true;
		}
		return isSymmetricUtil(root.left,root.right);
	}
	public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
		if(left == null && right == null)
		{
			return true;
		}
		if(left == null | right == null)
		{
			return false;
		}
		if(left.val != right.val)
		{
			return false;
		}

		if(!isSymmetricUtil(left.left,right.right))
			return false;
		if(!isSymmetricUtil(left.right,right.left))
			return false;
		return true;
	}
	public static void main(String args[])
	{
		SymmetricTree tree = new SymmetricTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(3);
		Boolean b = tree.isSymmetric(tree.root);
		System.out.println(b);


	}
}
