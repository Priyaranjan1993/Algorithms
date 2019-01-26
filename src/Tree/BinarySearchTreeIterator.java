package Tree;

import java.util.Stack;

public class BinarySearchTreeIterator {

	Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode t = stack.pop();
        pushAll(t.right);
        return t.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void pushAll(TreeNode root)
    {
    	for(;root != null; root = root.left)
    	{
    		stack.push(root);
    	}
    }
}
