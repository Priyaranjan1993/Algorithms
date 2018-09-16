package Arrays;

public class ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {

		int numCols = matrix[0].length;
		int numRows = matrix.length;

		for(int j=0; j<numCols; j++)
		{
			if(!checkIsValid(matrix,0,j,numRows,numCols))
			{
				return false;
			}
		}

		for(int i=1; i < numRows; i++)
		{
			if(!checkIsValid(matrix,i,0,numRows,numCols))
			{
				return false;
			}
		}
		return true;

	}

	private boolean checkIsValid(int[][] matrix, int i, int j, int rows, int cols) {
		// TODO Auto-generated method stub
		int val = 0;
		if(i < rows && j < cols)
		{
			val = matrix[i][j];
		}
		//System.out.println("rows = "+ rows);
		//System.out.println("columns = "+ cols);

		while(++i < rows && ++j < cols )
		{
			//System.out.println(i);
			if(val != matrix[i][j])
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String args[])
	{
		ToeplitzMatrix t = new ToeplitzMatrix();
		/*		int mat[][] = { { 6, 7, 8, 9 },
				{ 4, 6, 7, 8 },
				{ 1, 4, 6, 7 },
				{ 0, 1, 4, 6 },
				{ 2, 0, 1, 4 }
		};*/
		int mat[][] = { { 11, 74, 0, 93 },
						{ 40, 11, 74, 7 }

		};

		boolean b = t.isToeplitzMatrix(mat);
		System.out.println(b);
	}

}
