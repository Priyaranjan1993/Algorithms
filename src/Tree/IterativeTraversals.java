package Tree;

import java.util.Stack;

class Treenodes{
	int val;
	Treenodes left;
	Treenodes right;

	Treenodes(int val)
	{
		this.val = val;
		left = right = null;
	}
}

public class IterativeTraversals {

	public void preOrder(Treenodes root){
		Stack<Treenodes> stack = new Stack<>();
		Treenodes current = root;
		stack.push(current);

		while(!stack.isEmpty())
		{
			Treenodes pop = stack.pop();
			System.out.println(pop.val);

			if(pop.right!=null)
			{
				stack.push(pop.right);
			}

			if(pop.left!=null)
			{
				stack.push(pop.left);
			}
		}

	}

	public void postOrder(Treenodes root){
		Stack<Treenodes> stack = new Stack<>();
		Treenodes current = root;
		stack.push(current);

		while(!stack.isEmpty())
		{
			Treenodes pop;
			Treenodes curr = stack.peek();
			if(isLeaf(curr))
			{
				pop = stack.pop();
				System.out.println(pop.val);
			}

			if(curr.right!=null)
			{
				stack.push(curr.right);
				curr.right = null;
			}

			if(curr.left!=null)
			{
				stack.push(curr.left);
				curr.left = null;
			}
		}
	}

	public boolean isLeaf(Treenodes curr) {
		return curr.left == null ? curr.right == null : false;
	}

	private void inOrder(Treenodes root) {
		Stack<Treenodes> stack = new Stack<>();
		Treenodes current = root;
		while(!stack.isEmpty() || current != null)
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else {
				Treenodes pop = stack.pop();
				System.out.println(pop.val);
				current = pop.right;
			}
		}
	}
}
