package LinkedList;

import LinkedList.Addition.ListNode;

public class Merge2SortedListB {


	public static ListNode head1, head2;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1 == null)
		{
			return l2;
		}

		if(l2 == null)
		{
			return l1;
		}

		if(l1.val < l2.val)
		{
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}

	}


	public void print(ListNode node) {
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
	}


	public static void main(String[] args) { 
		Merge2SortedListB list = new Merge2SortedListB(); 

		list.head1 = new ListNode(1); 
		list.head1.next = new ListNode(2); 
		list.head1.next.next = new ListNode(4);
		System.out.print("First List is "); 
		list.print(head1); 

		list.head2 = new ListNode(1); 
		list.head2.next = new ListNode(3);
		list.head2.next.next = new ListNode(4);
		System.out.print("Second List is "); 
		list.print(head2); 

		ListNode rs = list.mergeTwoLists(head1, head2); 
		System.out.print("Resultant List is "); 
		list.print(rs); 
	} 

}
