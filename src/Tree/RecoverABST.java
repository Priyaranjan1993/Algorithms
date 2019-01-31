package Tree;
import java.util.*;

public class RecoverABST {
	TreeNode root;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	TreeNode first;
	TreeNode last;

	public void recoverTree(TreeNode root) {
		Inorder(root);
		int temp = first.val;
		first.val = last.val;
		last.val = temp;
	}


	private void Inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while(!stack.isEmpty() || current != null)
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else {
				TreeNode pop = stack.pop();
				if(prev.val >= pop.val && first == null)
				{
					first = prev;
					System.out.println(first.val);
				}
				if(prev.val >= pop.val && first != null)
				{
					last = pop;
					System.out.println(last.val);
				}
				prev = pop;
				current = pop.right;
			}
		}
	}


	public static void main(String args[]) {
		RecoverABST r = new RecoverABST();
/*		r.root = new TreeNode(3);
		r.root.left = new TreeNode(1);
		r.root.right = new TreeNode(4);
		r.root.right.left = new TreeNode(2);*/
		
		r.root = new TreeNode(1);
		r.root.left = new TreeNode(3);
		r.root.left.right = new TreeNode(2);
		r.recoverTree(r.root);
	}
}

