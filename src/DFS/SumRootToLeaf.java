package DFS;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
	TreeNode root;
    public int sumNumbers(TreeNode root) {
    	int result = 0;
    	if(root == null)
    		return 0;
    	List<List<TreeNode>> res = new ArrayList<>();
    	List<TreeNode> ls = new ArrayList<>();
    	ls.add(root);
    	dfs(root,ls,res);
    	
    	for(List<TreeNode> t : res)
    	{
    		StringBuilder sb = new StringBuilder();
    		for(TreeNode n : t)
    		{
    			sb.append(Integer.toString(n.val));
    		}
    		int val = Integer.parseInt(sb.toString());
    		result = result + val;
    	}
		return result;
    }

	private void dfs(TreeNode root, List<TreeNode> ls, List<List<TreeNode>> res) {
		
		if(root.left == null && root.right == null)
		{
			ArrayList<TreeNode> ar = new ArrayList<>();
			ar.addAll(ls);
			res.add(ar);
		}
		if(root.left != null)
		{
			ls.add(root.left);
			dfs(root.left,ls,res);
			ls.remove(ls.size() - 1);
		}
		
		if(root.right != null)
		{
			ls.add(root.right);
			dfs(root.right,ls,res);
			ls.remove(ls.size() - 1);
		}
	}
	
	public static void main(String args[]) {
		SumRootToLeaf tree = new SumRootToLeaf();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		int res = tree.sumNumbers(tree.root);
		System.out.println(res);
	}
}
