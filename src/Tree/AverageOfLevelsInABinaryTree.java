package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInABinaryTree {
	TreeNode root;

/*	public List<Double> averageOfLevels(TreeNode root) {
		List<Integer> count = new ArrayList<Integer>();
		List<Double> sum = new ArrayList<Double>();
		List<Double> result = new ArrayList<Double>();
		averageCalculation(root, 0, count, sum);
		for(int i =0 ; i< sum.size(); i++)
		{
			result.add((double) (sum.get(i)/count.get(i)));
		}
		return result;
	}*/

/*	public void averageCalculation(TreeNode root, int i, List<Integer> count, List<Double> sum) {
		if(root == null)
		{
			return;
		}
		if(i < sum.size())
		{
			sum.set(i, sum.get(i)+root.val);
			count.set(i,count.get(i)+1);
		}
		else {
			sum.add(1.0 * root.val);
			count.add(1);
		}
		averageCalculation(root.left, i+1, count, sum);
		averageCalculation(root.right, i+1, count, sum);
	}*/
	
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		if (root == null)
		{
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null)
		{
			queue.add(root);
		}
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			int total = size;
			double average = 0;
			double sum = 0;
			while(size > 0)
			{
				size--;
				TreeNode t = queue.poll();
				sum = sum + t.val;
				if(t.left != null)
				{
					queue.add(t.left);
				}
				if(t.right != null)
				{
					queue.add(t.right);
				}
			}
			average = sum/total;
			result.add(average);
		}
		
		return result;
	}

	public static void main(String args[])
	{
		AverageOfLevelsInABinaryTree tree = new AverageOfLevelsInABinaryTree();
/*		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left = new TreeNode(1);

		tree.root.right = new TreeNode(6);
		tree.root.left.right = new TreeNode(4);*/
		
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.left.left = new TreeNode(15);
		
		tree.root.right = new TreeNode(20);
		tree.root.left.right = new TreeNode(7);
		
		
		List<Double> result = new ArrayList<Double>();
		result = tree.averageOfLevels(tree.root);
		for(Double d : result)
		{
			System.out.println(d);
		}
	}
}
