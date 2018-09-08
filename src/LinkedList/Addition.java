package LinkedList;

public class Addition {

	public static ListNode head1, head2;

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode temp;
		ListNode prev = null;
		int sum = 0, carry = 0;

		while(l1 != null || l2!= null)
		{
			sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

			if(sum >= 10)
			{
				carry = 1;
			}

			else {
				carry = 0;
			}

			sum = sum % 10;

			temp = new ListNode(sum);

			if(result == null ) {
				result = temp;
			}
			else {
				prev.next = temp;
			}

			prev = temp;

			if(l1 != null ) {
				l1 = l1.next;
			}

			if(l2 != null) {
				l2 = l2.next;
			}
		}

		if(carry > 0) {
			prev.next = new ListNode(carry);
		}

		return result;
	}

	public void print(ListNode node) {
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) { 
		Addition list = new Addition(); 

		// creating first list 
		list.head1 = new ListNode(5); 
/*		list.head1.next = new ListNode(5); 
		list.head1.next.next = new ListNode(9); 
		list.head1.next.next.next = new ListNode(4); 
		list.head1.next.next.next.next = new ListNode(6); */
		System.out.print("First List is "); 
		list.print(head1); 

		// creating seconnd list 
		list.head2 = new ListNode(5); 
/*		list.head2.next = new ListNode(4); */
		System.out.print("Second List is "); 
		list.print(head2); 

		// add the two lists and see the result 
		ListNode rs = list.addTwoNumbers(head1, head2); 
		System.out.print("Resultant List is "); 
		list.print(rs); 
	} 
}
