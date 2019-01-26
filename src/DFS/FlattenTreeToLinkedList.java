package DFS;

public class FlattenTreeToLinkedList {
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		else {
			flattenUtil(root);
		}
	}

	private TreeNode flattenUtil(TreeNode root) {
		if(root.left != null && root.right != null)
		{
			TreeNode right = flattenUtil(root.right);
			TreeNode left = flattenUtil(root.left);
			left.right = root.right;
			root.right = root.left;
			root.left = null;
			return right;
		}
		else if(root.left == null && root.right != null)
		{
			return flattenUtil(root.right);
		}
		else if(root.left != null && root.right == null)
		{
			TreeNode left = flattenUtil(root.left);
			root.right = root.left;
			root.left = null;
			return left;
		}
		else
		{
			return root;
		}
	}
}
