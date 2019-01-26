package Tree;

import java.util.*;

public class FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new LinkedList<>();
		preorder(root, new HashMap<>(), res);
		return res;
	}

	public String preorder(TreeNode curr, Map<String, Integer> map, List<TreeNode> res) {
		if(curr == null)
		{
			return "#";
		}
		String result = curr.val +""+ preorder(curr.left, map, res) +""+ preorder(curr.right, map, res);
		if(map.get(result) != null && map.get(result) == 1)
		{
			res.add(curr);
		}
		map.put(result, map.getOrDefault(result, 0) + 1);
		return result;
	}
}
