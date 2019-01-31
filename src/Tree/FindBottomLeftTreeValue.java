package Tree;
import java.util.*;

public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		if(root == null)
			return -1;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode curr = root;
		queue.add(curr);

		while(!queue.isEmpty())
		{
			int size = queue.size();
			while(size > 0)
			{
				size--;
				curr = queue.poll();
				if(curr.right != null)
				{
					queue.add(curr.right);
				}
				if(curr.left != null)
				{
					queue.add(curr.left);
				}
			}
		}

		return curr.val;
	}
}
