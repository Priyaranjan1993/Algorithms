package Arrays;

import java.util.HashSet;
import java.util.Set;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class TwoSum4 {
	TreeNode root;
	Set<Integer> set = new HashSet<>();
	public boolean findTarget(TreeNode root, int k) {
		return findTargetUtil(root,k);
	}

	private boolean findTargetUtil(TreeNode root, int k) {
		if(root == null)
			return false;
		if(set.contains(k - root.val))
		{
			return true;
		}
		set.add(root.val);
		return findTargetUtil(root.left, k) || findTargetUtil(root.right, k);

	}
	
	public static void main(String args[])
	{
		TwoSum4 tree = new TwoSum4();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(4);
		int k = 9;
		System.out.println(tree.findTarget(tree.root, k));
	}
}
