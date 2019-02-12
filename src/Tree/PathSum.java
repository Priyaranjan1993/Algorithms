package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	TreeNode root;
	public boolean hasPathSum(TreeNode root, int sum) {
		List<Integer> ls = new ArrayList<Integer>();
		List<List<Integer>> val = new ArrayList<>();
		Boolean b = false;
		hasPathSumUtil(root,sum,ls,b,val);
		if(!val.isEmpty())
		{
			return true;
		}
		return false;
	}
	public void hasPathSumUtil(TreeNode root, int sum, List<Integer> ls, Boolean b, List<List<Integer>> val) {
		if(root == null)
		{
			return;
		}
		ls.add(root.val);

		if(root.left == null && root.right == null)
		{
			int total = 0;
			for(int x : ls)
			{
				total += x;
			}
			if(total == sum)
			{
				val.add(new ArrayList<>(ls));
			}
			ls.remove(ls.size() - 1);
			return;
		}

		if(root.left != null)
		{
			hasPathSumUtil(root.left,sum,ls,b,val);
		}
		if(root.right != null)
		{
			hasPathSumUtil(root.right,sum,ls,b,val);
		}
		ls.remove(ls.size() - 1);
		return;
	}
	public static void main(String args[])
	{
		PathSum tree = new PathSum();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(4);
		tree.root.left.left = new TreeNode(11);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(2);

		tree.root.right = new TreeNode(8);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right.left = new TreeNode(5);
		tree.root.right.right.right = new TreeNode(1);

		Boolean b =tree.hasPathSum(tree.root, 22);
		System.out.println(b);
	}
}
