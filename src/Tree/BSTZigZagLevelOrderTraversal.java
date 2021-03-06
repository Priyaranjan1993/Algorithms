package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
		{
			return result;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);

		while(!s1.isEmpty() || !s2.isEmpty())
		{
			List<Integer> ls= new LinkedList<>();
			while(!s1.isEmpty())
			{
				int size = s1.size();

				for(int i = 0; i < size ; i++)
				{
					TreeNode pop = s1.pop();
					ls.add(pop.val);
					while(pop.left != null)
					{
						s2.push(pop.left);
					}
					while(pop.right != null)
					{
						s2.push(pop.right);
					}
				}
			}
			
			result.add(ls);
			ls = new LinkedList<>();
			while(!s2.isEmpty())
			{
				int size = s2.size();

				for(int i = 0; i < size ; i++)
				{
					TreeNode pop = s2.pop();
					ls.add(pop.val);
					while(pop.right != null)
					{
						s1.push(pop.right);
					}
					while(pop.left != null)
					{
						s1.push(pop.left);
					}
				}
				
				if(!ls.isEmpty())
				{
					result.add(ls);
				}

			}
		}
		return result;
	}
}
