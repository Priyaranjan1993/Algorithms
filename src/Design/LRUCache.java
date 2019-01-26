package Design;

import java.util.HashMap;
import java.util.Map;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/

/*LRUCache cache = new LRUCache( 2 // capacity // );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

class Node{
	int key;
	int val;
	Node prev;
	Node next;

	Node(int key,int val)
	{
		this.key = key;
		this.val = val;
	}
}

public class LRUCache {

	Map<Integer, Node> map = new HashMap<>();
	int capacity= 0;
	Node head = null;
	Node end = null;


	public LRUCache(int capacity) {
		this.capacity = capacity;
	}


	public int get(int key) {
		if(map.containsKey(key))
		{
			Node r = map.get(key);
			remove(r);
			setHead(r);
			return r.val;	
		}
		else {
			return -1;
		}

	}

	public void setHead(Node n)
	{
		n.next = head;
		n.prev = null;

		if(head != null)
		{
			head.prev = n;
		}

		head = n;

		if(end == null)
		{
			end = head;
		}
	}

	public void remove(Node n)
	{
		if(n.prev == null)
		{
			head = n.next;
		}
		else {
			n.prev.next = n.next;
		}

		if(n.next == null)
		{
			 end = n.prev;
		}
		else {
			n.next.prev = n.prev;
		}

	}

	public void put(int key, int value) {
		if(map.containsKey(key))
		{
			Node oldVal = map.get(key);
			oldVal.val = value;
			remove(oldVal);
			setHead(oldVal);
		}
		else {
			Node newNode = new Node(key, value);
			if(map.size() >= capacity)
			{
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			}
			else {
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}
}
