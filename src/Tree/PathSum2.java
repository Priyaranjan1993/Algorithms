package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	TreeNode root;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ls = new ArrayList<>();
		List<Integer> innerList = new ArrayList<>();
		pathSumUtil(root,sum,ls,innerList);
		return ls;
	}
	public void pathSumUtil(TreeNode root, int sum, List<List<Integer>> ls, List<Integer> innerList) {
		if(root == null)
		{
			return;
		}
		innerList.add(root.val);
		if(root.left == null && root.right == null)
		{
			int total = 0;
			for(int x : innerList)
			{
				total = total + x;
			}
			if(total == sum)
			{
				ls.add(new ArrayList<>(innerList));
			}
			innerList.remove(innerList.size() - 1);
			return;
		}

		if(root.left != null)
		{
			pathSumUtil(root.left,sum,ls,innerList);
		}
		if(root.right != null)
		{
			pathSumUtil(root.right,sum,ls,innerList);
		}
		innerList.remove(innerList.size() - 1);
	}
	public static void main(String args[])
	{
		PathSum2 tree = new PathSum2();
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
		List<List<Integer>> ls = new ArrayList<>();
		ls = tree.pathSum(tree.root, 22);
		for(List<Integer> x : ls)
		{
			for(int i : x)
			{
				System.out.println(i);
			}
			System.out.println("----------------------------");
		}
	}
}
