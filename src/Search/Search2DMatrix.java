package Search;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
		{
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;

		while(matrix.length - 1 >= row && col >= 0)
		{
			if(matrix[row][col] == target)
			{
				return true;
			}

			if(target > matrix[row][col])
			{
				row ++;
			}
			else {
				col --;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		Search2DMatrix demo = new Search2DMatrix();
		int[][] nums = new int[][] {{1}};
		int target = 2;
		boolean ans = demo.searchMatrix(nums, target);
		System.out.println(ans);
	}
}
