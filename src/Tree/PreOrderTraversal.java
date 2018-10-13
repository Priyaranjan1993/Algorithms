package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*  Definition for a binary tree node.*/
/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 */

public class PreOrderTraversal {
	TreeNode root;
	List<Integer> ls = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();
	//recursive
	private List<Integer> preOrderRecursive(TreeNode root) {
		if(root == null)
		{
			return null;
		}
		//System.out.println(root.val);
		ls.add(root.val);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
		return ls;
	}
	//Iterative
	private List<Integer> preOrderIterative(TreeNode root) {
		if(root == null)
		{
			return ls;
		}
		s.push(root);
		while(!s.isEmpty())
		{
			TreeNode t = s.pop();
			ls.add(t.val);
			if(t.right !=null)
			{
				s.push(t.right);
			}
			if(t.left !=null)
			{
				s.push(t.left);
			}
		}
		return ls;
	}

	public static void main(String args[])
	{
		PreOrderTraversal tree = new PreOrderTraversal();
		List<Integer> ls2 = new ArrayList<>();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		//ls2 = tree.preOrderRecursive(tree.root);
		ls2 = tree.preOrderIterative(tree.root);
		for(int x : ls2)
		{
			System.out.println(x);
		}

	}

}
