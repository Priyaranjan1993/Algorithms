package Tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
	TreeNode root;

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> ls = new ArrayList<>();
		findLeavesUtil(root,ls);
		return ls;
	}

	public int findLeavesUtil(TreeNode root, List<List<Integer>> ls) {
		if(root == null)
		{
			return -1;
		}
		int left = findLeavesUtil(root.left,ls);
		int right = findLeavesUtil(root.right, ls);
		int depthAtCurrentLevel = Math.max(left, right)+1;

		if(ls.size() <= depthAtCurrentLevel)
		{
			ls.add(new ArrayList<Integer>());
		}
		ls.get(depthAtCurrentLevel).add(root.val);
		return depthAtCurrentLevel;
	}

	public static void main(String args[])
	{
		FindLeaves tree = new FindLeaves();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		List<List<Integer>> ls = new ArrayList<>();
		ls = tree.findLeaves(tree.root);

		for(List<Integer> l: ls)
		{
			for(int x : l)
			{
				System.out.println(x);
			}
			System.out.println("------------------------------");
		}
	}
}
