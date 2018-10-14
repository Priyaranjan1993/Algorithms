package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderSuccessorBST {
	TreeNode root;


	public TreeNode inOrderSuccessor(TreeNode root, int i) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list = getInorderList(root,list);
		for(int k=0; k< list.size();k++)
		{
			if(list.get(k).val == i)
			{
				if(k+1 > list.size()-1)
				{
					return null;
				}
				else {
					return list.get(k+1);
				}

			}
		}
		return null;
	}

	public List<TreeNode> getInorderList(TreeNode root, List<TreeNode> list)
	{
		Stack<TreeNode> s = new Stack<>();
		if(root == null)
		{
			return null;
		}
		TreeNode current = root;
		while(!s.empty() || current != null)
		{
			if(current != null)
			{
				s.push(current);
				current = current.left;
			}
			else {
				TreeNode n = s.pop();
				list.add(n);
				current = n.right;
			}
		}
		return list;
	}

	public static void main(String args[])
	{
		InorderSuccessorBST tree = new InorderSuccessorBST();
		/*		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);

		tree.root.right = new TreeNode(6);*/
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);

		System.out.println(tree.inOrderSuccessor(tree.root,6));
	}

}
