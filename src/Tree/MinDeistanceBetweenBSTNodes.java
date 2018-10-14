package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinDeistanceBetweenBSTNodes {
	TreeNode root;
	List<Integer> ls = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();
	int prev = 0;
	int initial = Integer.MAX_VALUE;
	
	public int minDistance(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		minDistance(root.left);
		if(prev != 0)
		{
			initial = Math.min(initial, root.val - prev);
		}
		prev = root.val;
		minDistance(root.right);
		return initial;
	}

	public static void main(String args[])
	{
		MinDeistanceBetweenBSTNodes tree = new MinDeistanceBetweenBSTNodes();
		List<Integer> ls2 = new ArrayList<>();
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);
		//tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(6);
		//tree.root.right.right = new TreeNode(6);
		System.out.println(tree.minDistance(tree.root));
	}
}
