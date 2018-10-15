package Tree;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInRow {
	TreeNode root;

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> counter = new ArrayList<>();
		largestValuesUtil(root,0,counter);
		return counter;
	}

	public void largestValuesUtil(TreeNode root, int i, List<Integer> counter) {
		if(root == null)
		{
			return;
		}
		if(i < counter.size())
		{
			counter.set(i, Math.max(counter.get(i),root.val));
		}
		else {
			counter.add(root.val);
		}

		largestValuesUtil(root.left, i+1, counter);
		largestValuesUtil(root.right, i+1, counter);
	}

	public static void main(String args[])
	{
		LargestValueInRow tree = new LargestValueInRow();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);

		System.out.println(tree.largestValues(tree.root));
	}
}
