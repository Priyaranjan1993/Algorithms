package Tree;

public class MergeTwoBinaryTress {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		return merge(t1,t2);
	}

	private TreeNode merge(TreeNode t1, TreeNode t2) {
		TreeNode root;
		if(t1 != null && t2 != null)
		{
			int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
			root= new TreeNode(val);
		}
		else {
			root = null;
		}

		root.left = merge(t1== null ? null : t1.left, t2== null ? null : t2.left);
		root.right = merge(t1== null ? null : t1.right, t2== null ? null : t2.right);

		return root;

	}
}
