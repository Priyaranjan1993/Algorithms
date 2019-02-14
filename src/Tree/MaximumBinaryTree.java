package Tree;
import java.util.*;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
    
    public static void main(String args[])
    {
    	MaximumBinaryTree m = new MaximumBinaryTree();
    	int[] nums = new int[] {3,2,1,6,0,5};
    	TreeNode t = m.constructMaximumBinaryTree(nums);
    	System.out.println(t);
    	
    }
}
