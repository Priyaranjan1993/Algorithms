package Tree;

public class InsertIntoABST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
		{
			return new TreeNode(val);
		}
		TreeNode current = root;

		while(true)
		{
			if(val >= current.val)
			{
				if(current.right!= null)
				{
					current = current.right;
				}
				else {
					current.right = new TreeNode(val);
					break;
				}
			}
			else if(val < current.val)
			{
				if(current.left!= null)
				{
					current = current.left;
				}
				else {
					current.left = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}
}
