package Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
	TreeNode root;
	List<Integer> ls = new ArrayList<>();
	int count = 0;
	Boolean b = true;
	public boolean isValidBST(TreeNode root)
	{
		inOrder(root);
		return b;
	}

	private void inOrder(TreeNode root) {
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		ls.add(root.val);
		if(count != 0 && root.val <= ls.get(count -1))
		{
			b = false;
		}
		count++;
		inOrder(root.right);
	}


	public static void main(String args[])
	{
		ValidateBST tree = new ValidateBST();

/*		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(1);

		tree.root.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);*/
		
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(3);
		
		Boolean b = tree.isValidBST(tree.root);
		System.out.println(b);
	}
}
