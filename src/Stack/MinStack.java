package Stack;

class Node {
	int val;
	int min;
	Node next;

	Node(int val, int min)
	{
		this.val = val;
		this.min = min;
	}
}

public class MinStack {
	Node root;
	public MinStack() {

	}

	public void push(int x) {
		if(root == null)
		{
			root = new Node(x,x);
		}
		else {
			Node temp = new Node(x, Math.min(x, root.min));
			temp.next = root;
			root = temp;
		}
	}

    public void pop() {

    	if(root == null)
    	{
    		return;
    	}
    	else {
    		Node temp = root.next;
    		root.next = null;
    		root = temp;
    	}
    }

    public int top() {
    	if(root == null)
    		return -1;
    	else
    		return root.val;
    }

    public int getMin() {
    	if(root == null)
    		return -1;
    	else
    		return root.min;
    }
    
    
    public static void main(String args[])
    {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	System.out.println(minStack.top());
    	System.out.println(minStack.getMin());
    }
}
