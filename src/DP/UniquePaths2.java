package DP;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid == null)
		{
			return 0;
		}
		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		
		int[][] res = new int[rows][cols];

		for(int i=0; i < rows; i++)
		{
			if(obstacleGrid[i][0] == 1)
			{
				break;
			}	
			else {
				res[i][0] = 1;
			}
		}

		for(int j=0; j < cols; j++)
		{
			if(obstacleGrid[0][j] == 1)
			{
				break;
			}
			else {
				res[0][j] = 1;
			}
		}
		
		for(int a = 1; a< rows; a ++)
		{
			for(int b = 1 ; b < cols ; b++)
			{
				if(obstacleGrid[a][b] != 1)
				{
					res[a][b] = res[a -1][b] + res[a][b - 1];
				}
			}
		}
		
		return res[rows -1 ][cols - 1];
	}
}
