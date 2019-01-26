package DFS;

import java.util.Comparator;
import java.util.PriorityQueue;

import Search.KthSmallestInBST;

class customComp implements Comparator<ListNode>
{

	@Override
	public int compare(ListNode l1, ListNode l2) {
		return l1.val - l2.val;
	}
	
}

public class mergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new customComp());

		ListNode head = new ListNode(0);
		ListNode p = head;

		for(ListNode list: lists){
			if(list!=null)
				queue.offer(list);
		}    

		while(!queue.isEmpty()){
			ListNode n = queue.poll();
			p.next = n;
			p=p.next;

			if(n.next!=null)
				queue.offer(n.next);
		}    

		return head.next;

	}
	
	public static void main(String args[])
	{
		mergeKLists lst = new mergeKLists();
		
		ListNode ls1 = new ListNode(1);
		ls1.next = new ListNode(4);
		ls1.next.next = new ListNode(5);
		
		ListNode ls2 = new ListNode(1);
		ls2.next = new ListNode(3);
		ls2.next.next = new ListNode(4);
		
		ListNode ls3 = new ListNode(2);
		ls3.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[] {ls1,ls2,ls3};
		ListNode result = null;
		result = lst.mergeKLists(lists);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
		//System.out.println("dd");
	}
}
