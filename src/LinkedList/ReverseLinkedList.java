package LinkedList;

import LinkedList.Merge2SortedList.ListNode;

public class ReverseLinkedList {

	
	public static ListNode head, prev, temp, next, r;

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
	
    public ListNode reverseList(ListNode hh) {
    	
    	temp = hh;
    	while(temp != null)
    	{
    		next = temp.next;
    		temp.next = prev;
    		prev = temp;
    		temp = next;
    	}
    	
    	hh = prev;
		return hh;
        
    }
    
	public static void main(String args[])
	{
		ReverseLinkedList list = new ReverseLinkedList();
		
		list.head = new ListNode(1); 
		list.head.next = new ListNode(2); 
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		System.out.print("Created List is "); 
		list.print(head); 

		r = list.reverseList(head);
		System.out.println("Reversed List ");
		list.print(r);


	}

}
