package Tree;

public class InvertABinaryTree {
	TreeNode root;

	public TreeNode invertTree(TreeNode root) {
		if(root != null)
		{
			invertNow(root);
		}
		return root;
	}

	private void invertNow(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		if(root.left != null)
		{
			invertNow(root.left);
		}

		if(root.right != null)
		{
			invertNow(root.right);
		}
	}

	public static void main(String args[])
	{
		InvertABinaryTree tree = new InvertABinaryTree();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);
		tree.inOrder(tree.root);
		System.out.println("-------------------------------------------------------------------------");
		tree.invertTree(tree.root);
		tree.inOrder(tree.root);
	}

	private void inOrder(TreeNode root) {
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

}
