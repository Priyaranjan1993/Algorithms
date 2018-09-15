package LinkedList;


public class RemoveLinkedListElements {

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

	public ListNode removeElements(ListNode head, int val) {
		ListNode temp = new ListNode(0);
		ListNode x = temp;
		temp.next = head;
		ListNode y = head;

		if(y!=null)
		{
			if(y.val == val)
			{
				return y.next != null ? removeElements(y.next,val) : null;
			}
			
			while(y !=null)
			{
				if(y.val == val)
				{
					x.next = y.next;
					y = y.next;
				}
				else {
					x = x.next;
					y = y.next;
				}
			}
		}
		else {
			return null;
		}

		return head;

	}

	public static void main(String args[])
	{
		RemoveLinkedListElements list = new RemoveLinkedListElements();

		list.head = new ListNode(1); 
	/*	list.head.next = new ListNode(1); */
/*		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		list.head.next.next.next.next.next = new ListNode(6);*/

		list.print(list.removeElements(list.head, 1));
	}
}
