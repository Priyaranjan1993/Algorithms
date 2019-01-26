package DFS;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> ls = new ArrayList<>();
    	findLeavesUtil(root,ls);
		return null;
    }

	private int findLeavesUtil(TreeNode root, List<List<Integer>> ls) {
		if(root == null)
			return -1;
		int left = findLeavesUtil(root.left,ls);
		int right = findLeavesUtil(root.right,ls);
		int height = Math.max(left, right)+1;
		
		if(height >= ls.size())
			ls.add(new ArrayList<Integer>());
		
		ls.get(height).add(root.val);
		return height;
	}
}
