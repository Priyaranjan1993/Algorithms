package Stack;
import java.util.*;

public class MaxStack {
	Deque<Integer> deque;
	PriorityQueue<Integer> pq;

	public MaxStack() {
		deque = new ArrayDeque<>();
		pq = new PriorityQueue<>( (a,b) -> b - a);
	}

	public void push(int x) {
		deque.addLast(x);
		pq.add(x);
	}

	public int pop() {
		int r = deque.removeLast();
		pq.remove(r);
		return r;
	}

	public int top() {
		return deque.peekLast();
	}

	public int peekMax() {
		return pq.peek();
	}

	public int popMax() {
		int r = pq.poll();
		deque.removeLastOccurrence(r);
		return r;
	}
}
