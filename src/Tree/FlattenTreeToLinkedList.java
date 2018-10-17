package Tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenTreeToLinkedList {
	TreeNode root;
	TreeNode custom;
	public void flatten(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		flattenUtil(root,ls);
		custom = new TreeNode(root.val);
		root = buildTree(ls,custom,1);
	}
	public TreeNode buildTree(List<Integer> ls, TreeNode custom, int i) {
		if(i != ls.size())
		{
			custom.left = null;
			custom.right = new TreeNode(ls.get(i));
			buildTree(ls,custom.right, i+1);
		}
		return custom;
	}
	public void flattenUtil(TreeNode root, List<Integer> ls) {
		if(root == null)
		{
			return;
		}
		ls.add(root.val);

		flattenUtil(root.left,ls);
		flattenUtil(root.right,ls);
	}

	public static void main(String args[])
	{
		FlattenTreeToLinkedList tree = new FlattenTreeToLinkedList();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		//tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(6);
		tree.flatten(tree.root);
	}
}
