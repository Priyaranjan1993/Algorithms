package DFS;

public class TreeFromPreOrderInOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preStart = 0;
		int preEnd = preorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;

		return buildTreeUtil(preorder,preStart,preEnd, inorder, inStart, inEnd);
	}
	public TreeNode buildTreeUtil(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if(inStart > inEnd || preStart > preEnd)
		{
			return null;
		}
		TreeNode root = null;
		root = new TreeNode(preorder[preStart]);
		int rootPos = 0;

		for(int i =0 ; i < inorder.length; i++)
		{
			if(inorder[i] == root.val)
			{
				rootPos = i;
				break;
			}
		}

		root.left = buildTreeUtil(preorder, preStart+1, preStart+(rootPos-inStart), inorder, inStart, rootPos - 1);
		root.right = buildTreeUtil(preorder,preStart+(rootPos - inStart)+1, preEnd, inorder, rootPos + 1, inEnd);
		return root;
	}
}
