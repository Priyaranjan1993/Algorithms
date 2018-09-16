package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if(nums == null || r * c != nums[0].length * nums.length)
		{
			return nums;
		}

		int[][] res = new int [r][c];
		Queue <Integer> q = new LinkedList<>();
		for (int i=0; i < nums.length; i++)
		{
			for(int j=0; j < nums[0].length; j++)
			{
				q.add(nums[i][j]);
			}
		}

		for(int m=0; m < r; m++)
		{
			for(int n=0; n < c; n++)
			{
				res[m][n] = q.remove();
			}
		}
		return res;
	}

	public static void main(String args[])
	{
		ReshapeMatrix r = new ReshapeMatrix();
		int mat[][] = { { 11, 74, 0, 93 },
				{ 40, 11, 74, 7 }

		};
		
		r.matrixReshape(mat, 1, 8);

	}
}
