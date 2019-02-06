package LinkedList;
public class PlusOne {

	ListNode head1 , next, temp, prev;
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

	public ListNode plusOne(ListNode head) {
		ListNode h2 = reverse(head);
		ListNode p = h2;

		while(p != null)
		{
			if(p.val+1 <= 9)
			{
				p.val = p.val + 1;
				break;
			}
			else {
				p.val = 0;
				if(p.next == null)
				{
					p.next = new ListNode(1);
					break;
				}
				p = p.next;
			}

		}

		return reverse(h2);

	}

	public ListNode reverse(ListNode ll)
	{
		prev = null;
		temp  = ll;

		while(temp != null)
		{
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		
		ll = prev;
		return ll;
	}


	public static void main(String[] args) { 
		PlusOne list = new PlusOne(); 

		// creating first linked list 
		
		list.head1 = new ListNode(9); 
		list.head1.next = new ListNode(9);
		
/*		list.head1 = new ListNode(3); 
		list.head1.next = new ListNode(6); 
		list.head1.next.next = new ListNode(1); 
		list.head1.next.next.next = new ListNode(1); 
		list.head1.next.next.next.next = new ListNode(3); 
*/
		list.print(list.plusOne(list.head1));

	}
}
