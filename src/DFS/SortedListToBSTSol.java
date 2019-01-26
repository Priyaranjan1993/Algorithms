package DFS;

import java.util.Stack;

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortedListToBSTSol {
	static ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

	private void inOrder(TreeNode root) {
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
				System.out.println(pop.val);
				current = pop.right;
			}
		}
	}

	public static void main(String args[])
	{
		ListNode ls = new ListNode(-10);
		ls.next = new ListNode(-3);
		ls.next.next = new ListNode(0);
		ls.next.next.next = new ListNode(5);
		ls.next.next.next.next = new ListNode(9);
		SortedListToBSTSol sol = new SortedListToBSTSol();
		sol.inOrder(sol.sortedListToBST(ls));

	}
}
