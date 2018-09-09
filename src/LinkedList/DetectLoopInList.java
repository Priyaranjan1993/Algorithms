package LinkedList;

public class DetectLoopInList {

	ListNode head,temp;

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

	public boolean hasCycle(ListNode head) {
		//Floyd's cycle detect algo
		ListNode slow = head;
		ListNode fast = head;

		while(slow != null && fast != null && fast.next != null)

		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast)
			{
				return true;
			}
		}
		return false;

	}


	public static void main(String args[])
	{
		DetectLoopInList list = new DetectLoopInList();

		list.head = new ListNode(1); 
		list.head.next = new ListNode(2); 
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);

		//list.head.next.next.next.next.next = list.head;
		/*System.out.print("Created List is "); 
		list.print(list.head); */

		Boolean b = list.hasCycle(list.head);
		if(b)
		{
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}


	}

}
