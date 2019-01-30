package Tree;

import java.util.LinkedList;

public class SerialiseAndDeserialiseABST {
	// Encodes a tree to a single string.

	public String serialize(TreeNode root) {
		if(root == null)
			return "#!";
		String res = root.val+"!";
		res+= serialize(root.left);
		res+= serialize(root.right);
		return res;

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] str = data.split("!");
		LinkedList<String> ls = new LinkedList<>();
		for(String s : str)
		{
			ls.add(s);
		}
		
		return deserialise(ls);
	}

	private TreeNode deserialise(LinkedList<String> ls) {
		String value = ls.poll();
		if(value.equals("#"))
		{
			return null;
		}
		TreeNode root = new TreeNode (Integer.parseInt(value));
		
		root.left = deserialise(ls);
		root.right = deserialise(ls);
		
		return root;
	}
}
