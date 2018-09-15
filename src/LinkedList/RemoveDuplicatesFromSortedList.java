package LinkedList;

public class RemoveDuplicatesFromSortedList {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public void print(ListNode node) {
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		ListNode y = temp;
		ListNode x = y != null ? y.next : null;

		if(head != null)
		{
			while(x!= null)
			{
				if(x.val == y.val)
				{
					y.next = x.next;
					x = x.next;
				}
				else {
					x = x.next;
					y = y.next;
				}
			}

			return head;
		}
		else {
			return null;
		}
	}


	public static void main(String args[])
	{
		RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();

		list.head = null;
/*		list.head = new ListNode(1); 
		list.head.next = new ListNode(1); 
		list.head.next.next = new ListNode(2);*/
/*		list.head.next.next.next = new ListNode(2);
		list.head.next.next.next.next = new ListNode(2);
		list.head.next.next.next.next.next = new ListNode(3);*/

		list.print(list.deleteDuplicates(list.head));
	}
}
