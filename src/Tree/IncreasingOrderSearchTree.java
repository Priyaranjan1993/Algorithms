package Tree;
import java.util.*;

public class IncreasingOrderSearchTree {
	TreeNode root;
	public TreeNode increasingBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode current = root;
		TreeNode temp = new TreeNode(0);
		TreeNode t = temp;
		while(!s.isEmpty() || current != null)
		{
			if(current != null)
			{
				s.push(current);
				current = current.left;
			}
			else {
				TreeNode pop = s.pop();
				pop.left = null;
				t.right = pop;
				t = pop;
				System.out.println(pop.val);
				current = pop.right;
			}
		}
		return temp.right;
	}
	
	public static void main(String args[]) {
		IncreasingOrderSearchTree k = new IncreasingOrderSearchTree();
		k.root = new TreeNode(1);
		k.root.left = new TreeNode(2);
		k.root.right = new TreeNode(3);
		k.increasingBST(k.root);
	}
}
