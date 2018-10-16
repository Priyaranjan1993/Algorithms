package Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
	TreeNode root;
	public List<String> binaryTreePaths(TreeNode root) {
		String str = "";
		List<String> output = new ArrayList<>();
		binaryTreePathsUtil(root,output,str);
		return output;
	}
	public void binaryTreePathsUtil(TreeNode root, List<String> output, String str) {
		if(root == null)
		{
			return;
		}
		str = str+"->"+root.val;
		if(root.left == null && root.right == null)
		{
			output.add(str.substring(2));
			return;
		}
		if(root.left != null)
		{
			binaryTreePathsUtil(root.left, output, str);
		}
		if(root.right != null)
		{
			binaryTreePathsUtil(root.right, output, str);
		}
	}
	public static void main(String args[])
	{

		RootToLeaf tree = new RootToLeaf();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);

		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(6);
		List<String> result = new ArrayList<String>();
		result = tree.binaryTreePaths(tree.root);
		for(String str : result)
		{
			System.out.println(str);
		}
	}
}
