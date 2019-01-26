package Search;

import java.util.ArrayList;
import java.util.Stack;

class TreeeNodes {
	int val;
	TreeeNodes left;
	TreeeNodes right;
	TreeeNodes(int x) { val = x; }
}

public class KthSmallestInBST {

	TreeeNodes root;
	public int kthSmallest(TreeeNodes root, int k) {
		ArrayList<Integer> arr = new ArrayList<>();
		helper(arr,root);
		return arr.get(k-1);
	}

	public void helper(ArrayList<Integer> arr, TreeeNodes root)
	{
		Stack<TreeeNodes> stack = new Stack<>();
		TreeeNodes current = root;
		while (!stack.isEmpty() || current != null)
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else {
				TreeeNodes popped = stack.pop();
				arr.add(popped.val);
				current = popped.right;
			}
		}
	}
	
	public static void main(String args[])
	{
		KthSmallestInBST bst = new KthSmallestInBST();
		bst.root = new TreeeNodes(3);
		bst.root.left = new TreeeNodes(1);
		bst.root.left.right = new TreeeNodes(2);
		bst.root.right = new TreeeNodes(4);
		System.out.println(bst.kthSmallest(bst.root, 1));

	}


}
