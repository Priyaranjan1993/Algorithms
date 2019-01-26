package DP;

public class UniquePaths {

	public int uniquePaths(int m, int n) {

		int[][] up = new int[n][m];

		for(int i = 0; i < n ; i++)
		{
			up[i][0] = 1;
		}

		for(int j = 0; j < m ; j++)
		{
			up[0][j] = 1;
		}

		for(int k = 1; k < n ; k++)
		{
			for(int l = 1; k < m ; k++)
			{
				up[k][l] = up [k - 1][l] + up [k][l - 1];
			}
		}

		return up[n-1][m-1];
	}
}
