package LinkedList;

public class MiddleValLinkedList {

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

	public ListNode middleNode(ListNode head) {
		ListNode temp = head;
		ListNode fast = temp;
		ListNode slow = temp;

		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("The mid node is -- "+slow.val);
		return slow;
	}

	public static void main(String args[])
	{
		MiddleValLinkedList list = new MiddleValLinkedList();

		list.head = null;
		list.head = new ListNode(1); 
		list.head.next = new ListNode(2); 
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		list.head.next.next.next.next.next = new ListNode(6);

		list.middleNode(list.head);
		/*System.out.print("Created List is ");
		list.print(list.head);*/
	}

}
