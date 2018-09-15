package LinkedList;

public class OddEvenLinkedList {

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

	public ListNode oddEvenList(ListNode head) {
		ListNode temp = head;
		ListNode x = temp;
		ListNode y = x != null ? x.next : null;
		ListNode xEnd = x;
		ListNode yStart = y;

		while(x!= null && y!= null)
		{
			xEnd = x;
			x.next = y.next;
			y.next = x.next != null ? x.next.next : null;
			x = x.next;
			y = y.next;
		}

		if(xEnd != null)
		{
			if(x == null)
			{
				xEnd.next = yStart;
			}
			else {
				x.next = yStart;
			}
		}


		return head;

	}


	public static void main(String args[])
	{
		OddEvenLinkedList list = new OddEvenLinkedList();

		list.head = new ListNode(1); 
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(5);
		list.head.next.next.next.next = new ListNode(6);
		list.head.next.next.next.next.next = new ListNode(4);
		list.head.next.next.next.next.next.next = new ListNode(7);

		list.print(list.oddEvenList(list.head));
	}
}
