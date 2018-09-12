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
		ListNode h1 = head;
		ListNode h2 = reverse(h1);

		while(h2 != null)
		{
			if(h2.val+1 <= 9)
			{
				h2.val = h2.val + 1;
				break;
			}
			else {
				h2.val = 0;
				if(h2.next == null)
				{
					h2.next = new ListNode(1);
					break;
				}
				h2 = h2.next;
			}

		}

		reverse(h2);
		return head;

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
		list.head1 = new ListNode(3); 
		list.head1.next = new ListNode(6); 
		list.head1.next.next = new ListNode(1); 
		list.head1.next.next.next = new ListNode(1); 
		list.head1.next.next.next.next = new ListNode(3); 

		list.print(list.plusOne(list.head1));

	}
}
