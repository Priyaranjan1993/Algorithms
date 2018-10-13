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

public class PostOrderTraversal {
	TreeNode root;
	List<Integer> ls = new ArrayList<>();
	//recursive
	private List<Integer> postOrderRecursive(TreeNode root) {
		if(root == null)
		{
			return null;
		}
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		ls.add(root.val);
		return ls;
	}
	//Iterative
	public List<Integer> postorderIter( TreeNode root) {
		if( root == null ) return ls;

		Stack<TreeNode> s = new Stack<TreeNode>( );
		TreeNode current = root;

		while( true ) {

			if(current != null )
			{
				if(current.right!= null)
				{
					s.push(current.right);
				}
				s.push(current);
				current = current.left;
				continue;
			}
			
			if(s.isEmpty())
			{
				return ls;
			}
			
			current = s.pop();
			
			if(current.right != null && !s.isEmpty() && current.right == s.peek())
			{
				s.pop();
				s.push(current);
				current = current.right;
			}
			else {
				ls.add(current.val);
				current = null;
			}
		}
	}

	public static void main(String args[])
	{
		PostOrderTraversal tree = new PostOrderTraversal();
		List<Integer> ls2 = new ArrayList<>();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		//ls2 = tree.postOrderRecursive(tree.root);
		ls2 = tree.postorderIter(tree.root);
		for(int x : ls2)
		{
			System.out.println(x);
		}

	}

}
