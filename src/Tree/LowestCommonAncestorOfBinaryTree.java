package Tree;

public class LowestCommonAncestorOfBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return lowestCommonAncestorUtil(root,p,q);
	}

	private TreeNode lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
		{
			return null;
		}

		if(root == p || root == q)
		{
			return root;
		}

		TreeNode left = lowestCommonAncestorUtil(root.left,p,q);
		TreeNode right = lowestCommonAncestorUtil(root.right,p,q);

		if(left != null && right != null)
		{
			return root;
		}
		else {
			return left!= null ? left: right;
		}
	}
}
