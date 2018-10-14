package Tree;

public class SameTree {

	TreeNode root;
	TreeNode root2;


	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
		{
			return true;
		}
		else if(p == null || q == null)
		{
			return false;
		}

		if(p.val == q.val)
		{
			return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
		}
		else {
			return false;
		}
	}

	public static void main(String args[])
	{
		SameTree tree = new SameTree();

		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);
		/*----------------------------------------------------*/
		tree.root2 = new TreeNode(5);
		tree.root2.left = new TreeNode(3);
		tree.root2.left.left = new TreeNode(2);
		tree.root2.left.left.left = new TreeNode(1);

		tree.root2.right = new TreeNode(6);
		tree.root2.left.right = new TreeNode(4);

		Boolean b = tree.isSameTree(tree.root,tree.root2);
		System.out.println(b);
	}

}
