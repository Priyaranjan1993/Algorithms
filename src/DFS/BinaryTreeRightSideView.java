package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	TreeNode root;
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ls = new ArrayList<>();
		if(root == null)
			return ls;
		rightSideViewUtil(root,ls);
		return ls;
	}

	private void rightSideViewUtil(TreeNode root, List<Integer> ls) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i< size; i++)
			{
				TreeNode elem = q.poll();
				if(i == 0)
				{
					ls.add(elem.val);
				}

				if(elem.right != null)
				{
					q.add(elem.right);
				}

				if(elem.left != null)
				{
					q.add(elem.left);
				}

			}
		}
	}
	
	public static void main(String args[])
	{
		BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(5);
		
		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(4);
		
		
		List<Integer> ls = tree.rightSideView(tree.root);
		for (int x : ls)
		{
			System.out.println(x);
		}
		
	}
}
