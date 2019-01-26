package DP;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		
		if(matrix.length == 0)
		{
			return 0;
		}
		int result = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] mat = new int[rows + 1][cols + 1];

		for(int i = 1; i <= rows ; i++)
		{
			for(int j = 1; j <= cols ; j++)
			{
				if(matrix[i -1][j -1] == 1)
				{
					mat[i][j] = Math.min(Math.min(mat[i][j-1], mat[i-1][j-1]), mat[i-1][j]) + 1;
					result = Math.max(result, mat[i][j]);
				}
			}
		}
		return result*result;
	}
}
