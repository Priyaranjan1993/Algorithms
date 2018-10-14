package Tree;

public class SortedArrayToBST {
	TreeNode root;

	public TreeNode sortArrayToBSTParent(int[] arr)
	{
		return sortArrayToBST(arr, 0, arr.length-1);
	}

	public TreeNode sortArrayToBST(int[] arr, int start, int end) {

		if(start > end)
		{
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);

		node.left = sortArrayToBST(arr, start, mid -1);
		node.right = sortArrayToBST(arr, mid+1, end);
		return node;
	}


	private void inOrder(TreeNode root) {
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	public static void main(String args[])
	{
		SortedArrayToBST s = new SortedArrayToBST();
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
		s.root = s.sortArrayToBSTParent(arr);
		s.inOrder(s.root);
	}

}
