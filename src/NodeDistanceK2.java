import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class NodeDistanceK2 {
	TreeNode root;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		Map<TreeNode,Integer> map = getParentNodeMap(root,target);
		List<Integer> ls = new ArrayList<>();
		List<Integer> ls2 = new ArrayList<>();
		List<Integer> ls3 = new ArrayList<>();
		TreeNode parent = null ;
		int dis = 0;
		for(TreeNode p : map.keySet())
		{
			parent = p;
			dis = map.get(p);
		}
		if(parent != null)
		{
			ls = kNearestNodes(parent,K);
			ls2 = kNearestNodes(root,K - dis);
		}
		for(int x : ls)
		{
			ls3.add(x);
		}
		for(int s : ls2)
		{
			if(s != target.val)
				ls3.add(s);
		}
		return ls3;
	}

	private List<Integer> kNearestNodes(TreeNode parent, int k) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(parent);
		int count = -1;
		List<Integer> ls = new ArrayList<Integer>();
		while(!queue.isEmpty())
		{
			int size = queue.size();
			count++;
			while(size > 0)
			{
				size --;
				TreeNode pop = queue.poll();
				if(count == k)
				{
					ls.add(pop.val);
				}
				if(pop.right != null)
				{
					queue.add(pop.right);
				}
				if(pop.left != null)
				{
					queue.add(pop.left);
				}
			}
		}
		return ls;
	}

	private Map<TreeNode,Integer> getParentNodeMap(TreeNode root, TreeNode target) {
		/*		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode pop = stack.pop();
			if(pop.val == target.val)
				return pop;
			if(pop.right != null)
			{
				stack.push(pop.right);
			}
			if(pop.left != null)
			{
				stack.push(pop.left);
			}
		}*/
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int count = -1;
		while(!q.isEmpty())
		{
			int size = q.size();
			count++;
			while(size > 0)
			{
				size --;
				TreeNode pop = q.poll();
				if(pop.val == target.val)
				{
					Map<TreeNode,Integer> map = new HashMap<>();
					map.put(pop,count);
					return map;
				}
				if(pop.right != null)
				{
					q.add(pop.right);
				}
				if(pop.left != null)
				{
					q.add(pop.left);
				}
			}
		}
		return null;
	}


	public static void main(String args[])
	{
		NodeDistanceK2 tree = new NodeDistanceK2();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(4);

		tree.root.right = new TreeNode(1);
		tree.root.right.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(0);

		TreeNode target = new TreeNode(5);

		List<Integer> ls = tree.distanceK(tree.root, target, 2);
		for(int x : ls)
		{
			System.out.println(x);
		}
	}
}
