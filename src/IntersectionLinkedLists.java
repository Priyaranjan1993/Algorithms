

public class IntersectionLinkedLists {

	ListNode head1 , head2, l1, l2;
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


	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int d;
		ListNode res;
		l1 = headA;
		l2 = headB;

		int a = getLength(l1);
		int b = getLength(l2);

		if(a > b)
		{
			d = a - b;
			res = findIntersection(d, l1, l2);
		}
		else {
			d = b - a;
			res = findIntersection(d, l2, l1);
		}


		return res;

	}

	public ListNode findIntersection(int d, ListNode a, ListNode b)
	{
		for(int x=0; x < d ; x++)
		{
			if(a == null)
			{
				return null;
			}
			a = a.next;
		}

		while(a != null && b!= null)
		{
			if(a.val == b.val)
			{
				return a;
			}

			a= a.next;
			b = b.next;
		}
		return null;

	}

	public int getLength(ListNode node)
	{
		int count = 0;
		while(node!= null)
		{
			count++;
			node = node.next;
		}
		return count;
	}


	public static void main(String[] args) { 
		IntersectionLinkedLists list = new IntersectionLinkedLists(); 

		// creating first linked list 
		list.head1 = new ListNode(3); 
		list.head1.next = new ListNode(6); 
		list.head1.next.next = new ListNode(15); 
		list.head1.next.next.next = new ListNode(15); 
		list.head1.next.next.next.next = new ListNode(30); 

		// creating second linked list 
		list.head2 = new ListNode(10); 
		list.head2.next = new ListNode(15); 
		list.head2.next.next = new ListNode(30); 

		ListNode res;
		res = list.getIntersectionNode(list.head1, list.head2);
		System.out.println(res.val);

		//System.out.println("The node of intersection is " + list.getNode()); 

	}

}
