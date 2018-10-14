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

public class InOrderTraversal {
	TreeNode root;
	List<Integer> ls = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();
	
	//recursive
	private List<Integer> inOrderRecursive(TreeNode root) {
		if(root == null)
		{
			return null;
		}
		inOrderRecursive(root.left);
		ls.add(root.val);
		inOrderRecursive(root.right);
		return ls;
	}
	//Iterative
	private List<Integer> inOrderIterative(TreeNode root) {
		if(root == null)
		{
			return ls;
		}
		TreeNode current = root;
		while(!s.isEmpty() || current != null)
		{
			if(current != null)
			{
				s.push(current);
				current = current.left;
			}
			else {
				ls.add(s.peek().val);
				TreeNode n = s.pop();
				current = n.right;
			}
		}
		return ls;
	}

	public static void main(String args[])
	{
		InOrderTraversal tree = new InOrderTraversal();
		List<Integer> ls2 = new ArrayList<>();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		//ls2 = tree.inOrderRecursive(tree.root);
		ls2 = tree.inOrderIterative(tree.root);
		for(int x : ls2)
		{
			System.out.println(x);
		}

	}

}
