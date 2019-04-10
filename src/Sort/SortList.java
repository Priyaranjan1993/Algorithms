package Sort;

/**
 * 
 * @author priya
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
		{
			return head;
		}

		ListNode slow,fast,prev = null;

		slow = head;
		fast = head;

		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		return merge(l1,l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {

		ListNode root = new ListNode(0);
		ListNode p = root;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				p.next = l1;
				l1 = l1.next;
			}
			else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if(l1 != null)
		{
			p.next = l1;
		}
		
		if(l2 != null)
		{
			p.next = l2;
		}
		return root.next;

	}
	
	public static void main(String args[]) {
		SortList s = new SortList();
		
		ListNode l1 = new ListNode(4); 
		l1.next = new ListNode(2); 
		l1.next.next = new ListNode(1);
		l1.next.next.next = new ListNode(3);
		ListNode r1 = s.sortList(l1);
		System.out.println(r1.val);
		System.out.println(r1.next.val);
		System.out.println(r1.next.next.val);
		System.out.println(r1.next.next.next.val);
	}
}
