package Queue;

public class MyCircularQueue {

	int[] arr;
	int len = 0;
	int rear = -1;
	int front = 0;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		arr = new int[k];
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if(!isFull())
		{
			rear = (rear+1) % arr.length;
			arr[rear] = value;
			len++;
			return true;
		}
		return false;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(!isEmpty())
		{
			front = (front + 1) % arr.length;
			len -- ;
			return true;
		}
		return false;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return isEmpty() ? -1:arr[front];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return isEmpty() ? -1:arr[rear];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return len == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return arr.length == len;
	}
}
