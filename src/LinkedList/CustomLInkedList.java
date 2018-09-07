package LinkedList;

public class CustomLInkedList<E> {

	private int size;
	customNode<E> first;
	customNode<E> last;

	public String toString() {
		String output = "";

		if (first != null) {
			customNode currentNode = first;
			while (currentNode != null) {
				output += currentNode.item.toString() + " | ";
				currentNode = currentNode.next;
			}

		}
		return output;
	}

	public void addFirst(E data){
		customNode<E> f = first;
		customNode<E> newNode = new customNode(null, data, f);
		if(f == null) {
			first = newNode;
			if(last == null) {
				last = newNode;
			}
		}
		else {
			first = newNode;
			f.prev = newNode;
		}
		size++;
	}

	public void addLast(E data) {
		customNode<E> previousItem = last;
		customNode<E> newNode = new customNode(previousItem, data, null);
		//last = newNode;
		if(previousItem != null)
		{
			last.next = newNode;
		}
		else {
			first = newNode;
			last = newNode;
		}
		size++;
	}

	public void add(int i, E data) {
		CustomLInkedList<E> c = new CustomLInkedList<E>();
		Boolean val = c.isValidPosition(i,size);

		if(val) {
			if(first != null) {
				customNode<E> prevItem = first;
				customNode<E> nextItem = first;
				for(int x=0; x<i - 2 ; x++) {
					prevItem = prevItem.next;
				}
				for(int x=0; x<i - 1 ; x++) {
					nextItem = nextItem.next;
				}

				customNode<E> newNode = new customNode(prevItem, data, nextItem);
				prevItem.next = newNode;
				nextItem.prev = newNode;
			}
			else {
				c.addFirst(data);
			}
			size++;
		}


	}

	public boolean isValidPosition(int x, int size) {
		if(x <= size) {
			return true;
		}
		else {
			return false;
		}

	}

	public static void main(String args[]) {
		CustomLInkedList<Integer> cc = new CustomLInkedList<Integer>();
		cc.addFirst(5);
		cc.addLast(7);
		cc.addFirst(225);
		cc.add(2, 15);
		cc.add(3, 21);
		System.out.println(cc);


	}

}

class customNode<E>
{
	E item;
	customNode<E> prev;
	customNode<E> next;

	customNode(customNode<E> prev, E item, customNode<E> next){
		this.item = item;
		this.next = next;
		this.prev = prev;
	}
}
