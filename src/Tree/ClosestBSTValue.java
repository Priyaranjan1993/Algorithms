package Tree;

public class ClosestBSTValue {
	TreeNode root;
	public int closestValue(TreeNode root, double target) {
	    int ret = root.val;   
	    while(root != null){
	        if(Math.abs(target - root.val) < Math.abs(target - ret)){
	            ret = root.val;
	        }      
	        root = root.val > target? root.left: root.right;
	    }     
	    return ret;
	}
	
	public static void main(String args[])
	{
		ClosestBSTValue tree = new ClosestBSTValue();
		double target = 3.714286;
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);
		tree.root.right = new TreeNode(5);
		tree.closestValue(tree.root, target);
	}
}
