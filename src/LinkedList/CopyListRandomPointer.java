package LinkedList;

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
	
	public RandomListNode copyRandomList(RandomListNode head) {
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
	}
	
}
