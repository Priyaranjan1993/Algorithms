package LinkedList;

import LinkedList.Merge2SortedListB.ListNode;

public class DeleteNode {


	public static ListNode head, prev;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}


	public void push(int val)
	{
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
	}

	public void print() {

		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.val+ " ");
			temp = temp.next;
		}
	}

	public void deleteNode(ListNode node) {

		ListNode h = head;

		if(h == null)
		{
			return;
		}

		if(h.val == node.val)
		{
			h = h.next;
		}
		else {
			while(h!= null && h.val != node.val)
			{
				prev = h;
				h = h.next;
			}

			if(h == null)
			{
				return;
			}

			prev.next = h.next;
		}

	}

	public static void main(String args[])
	{
		DeleteNode dl = new DeleteNode();

		dl.push(1);
		dl.push(2);
		dl.push(3);
		dl.push(4);
		dl.push(5);

		System.out.println("New Created List ");
		dl.print();

		ListNode l1 = new ListNode(2);

		dl.deleteNode(l1);
		System.out.println("Modified List ");
		dl.print();


	}


}
