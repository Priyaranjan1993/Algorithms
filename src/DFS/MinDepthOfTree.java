package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfTree {
	TreeNode root;
	public int minDepth(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
		if(isLeaf(root))
		{
			return 1;
		}

		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			count++;
			int size = queue.size();
			for(int i =0 ; i< size; i++)
			{
				TreeNode tree = queue.poll();
				if(isLeaf(tree))
				{
					return count;
				}
				if(tree.left != null)
				{
					queue.add(tree.left);
				}
				if(tree.right != null)
				{
					queue.add(tree.right);
				}
			}
		}
		return 0;
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	public static void main(String args[])
	{
		MinDepthOfTree tree = new MinDepthOfTree();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		
		int x = tree.minDepth(tree.root);
		System.out.println(x);
	}
}
