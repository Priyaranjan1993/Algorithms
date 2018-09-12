package LinkedList;

public class SwapNodeInPairs {

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

	public ListNode swapPairs(ListNode head) {

		ListNode l1 = new ListNode(0);
		ListNode t1,t2;
		l1.next = head;
		ListNode h = l1;

		while(h.next != null && h.next.next !=null)
		{
			t1 = h;
			h = h.next;
			t1.next = h.next;

			t2 = h.next.next;
			h.next.next = h;
			h.next = t2;
		}

		return l1.next;

	}

	public static void main(String args[])
	{
		SwapNodeInPairs list = new SwapNodeInPairs();

		list.head = null;
		list.head = new ListNode(1); 
		list.head.next = new ListNode(2); 
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		/*System.out.print("Created List is ");
		list.print(list.head);*/
		
		list.print(list.swapPairs(list.head));
	}

}
