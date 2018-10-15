package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BSTLevelOrderTraversalBottomUp {

	TreeNode root;

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> counter = new ArrayList<>();
		levelOrderUtil(root,0,counter);
		Collections.reverse(counter);
		return counter;
	}
	
	public void levelOrderUtil(TreeNode root, int i, List<List<Integer>> counter) {
		List<Integer> temp = new ArrayList<>();
		if(root == null)
		{
			return;
		}
		if(i < counter.size())
		{
			temp = counter.get(i);
			temp.add(root.val);
		}
		else {
			temp.add(root.val);
			counter.add(temp);
		}
		
		levelOrderUtil(root.left, i+ 1, counter);
		levelOrderUtil(root.right, i+ 1, counter);
	}
	public static void main(String args[])
	{
		BSTLevelOrderTraversalBottomUp tree = new BSTLevelOrderTraversalBottomUp();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);
		
		List<List<Integer>> ls = new ArrayList<>();
		ls = tree.levelOrder(tree.root);
		int counter = 0;
		for(List<Integer> l : ls)
		{
			System.out.println("for level "+counter);
			for(int x : l )
			{
				System.out.println(x);
			}
			counter++;
		}
		
	}
}
