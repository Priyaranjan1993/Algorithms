package Tree;

public class DeleteANode {
	TreeNode root;

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null)
		{
			return null;
		}
		if(root.val > key)
		{
			root.left = deleteNode(root.left,key);
		}
		else if(root.val < key)
		{
			root.right = deleteNode(root.right, key);
		}
		else {
			if(root.left != null && root.right != null)
			{
				TreeNode elem = findMinElementInRight(root.right);
				root.val = elem.val;
				root.right = deleteNode(root.right, elem.val);
			}
			else if(root.left != null)
			{
				root = root.left;
			}
			else if(root.right != null)
			{
				root = root.right;
			}
			else {
				root = null;
			}
		}
		return root;
	}
	
	public TreeNode findMinElementInRight(TreeNode root) {
		if(root.left == null)
		{
			return root;
		}
		else {
			return findMinElementInRight(root.left);
		}
	}
	public static void main(String args[]) {
		DeleteANode tree = new DeleteANode();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);
		tree.deleteNode(tree.root, 3);
	}
}
