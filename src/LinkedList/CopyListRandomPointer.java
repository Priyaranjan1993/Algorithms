package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {

	/*RandomListNode tempHead,oldNode, newNode, headOld, head1;*/
	/*Definition for singly-linked list with a random pointer.*/
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

	public void print(RandomListNode node) {
		while (node != null) {
			System.out.println(node.label + " ");
			node = node.next;
		}
	}

	/*	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode tempHead,oldNode, newNode, headOld;
		tempHead = head;

		if(head == null)
		{
			return null;
		}

		while(tempHead != null)
		{
			RandomListNode newNode2 = new RandomListNode(tempHead.label);

			newNode2.next = tempHead.next;
			tempHead.next = newNode2;
			tempHead = newNode2.next;
		}

		tempHead = head;

		while(tempHead!= null)
		{
			tempHead.next.random = (tempHead.random != null) ? tempHead.random.next : null;
			tempHead = tempHead.next.next;
		}

		oldNode = head;
		newNode = head.next;
		headOld = head.next;

		while(oldNode != null)
		{
			oldNode.next = newNode.next;
			oldNode = oldNode.next;
			newNode.next = (oldNode != null) ? oldNode.next : null;
			newNode = newNode.next;
		}

		return headOld;
	}*/

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		Map<RandomListNode,RandomListNode> map = new HashMap<>();

		RandomListNode tempHead = new RandomListNode(head.label);
		RandomListNode p = head;
		RandomListNode q = tempHead;

		map.put(head, tempHead);
		p = p.next;

		while(p != null)
		{
			RandomListNode newNode = new RandomListNode(p.label);
			map.put(p, newNode);
			q.next = newNode;
			q = q.next;
			p = p.next;
		}

		p = head;
		q = tempHead;

		while(p != null)
		{
			if(p.random != null)
			{
				q.random = map.get(p.random);
			}
			else {
				q.random = null;
			}

			p = p.next;
			q = q.next;
		}

		return tempHead;
	}

}
