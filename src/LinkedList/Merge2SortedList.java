package LinkedList;

import LinkedList.Addition.ListNode;

public class Merge2SortedList {


	public static ListNode head1, head2;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode temp = new ListNode(0);
		ListNode list1 = l1;
		ListNode list2 = l2;
		ListNode p = temp;

		while (list1 != null && list2 != null)
		{
			if(list1.val < list2.val)
			{
				p.next = list1;
				list1 = list1.next;
			}
			else {
				p.next = list2;
				list2 = list2.next;
			}

			p = p.next;
		}

		if(list1 != null)
		{
			p.next = list1;
		}

		if(list2 != null)
		{
			p.next = list2;
		}
		return temp.next;
	}


public void print(ListNode node) {
	while (node != null) {
		System.out.println(node.val + " ");
		node = node.next;
	}
}


public static void main(String[] args) { 
	Merge2SortedList list = new Merge2SortedList(); 

	list.head1 = new ListNode(1); 
	list.head1.next = new ListNode(2); 
/*	list.head1.next.next = new ListNode(4); */
	System.out.print("First List is "); 
	list.print(head1); 

	list.head2 = new ListNode(3); 
/*	list.head2.next = new ListNode(3);*/
/*	list.head2.next.next = new ListNode(4);*/
	System.out.print("Second List is "); 
	list.print(head2); 

	ListNode rs = list.mergeTwoLists(head1, head2); 
	System.out.print("Resultant List is "); 
	list.print(rs); 
} 

}
