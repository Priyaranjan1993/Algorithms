
public class Demo {
	static int getNumberOfIslands(int[][] binaryMatrix) {
		// your code goes here
		int rows = binaryMatrix.length - 1;
		int columns = binaryMatrix[0].length - 1;
		int count = 0;

		for(int i =0; i < rows; i++)
		{

			for(int j=0; j < columns; j++)
			{
				if(binaryMatrix[i][j]==1)
				{
					count++;
					helper(rows,columns,i,j, binaryMatrix);
				}
			}
		}
		return count;
	}

	private static void helper(int rows, int cols, int i, int j, int[][] binaryMatrix)
	{

		if(i <= rows && j <= cols && i >= 0 && j >= 0 && binaryMatrix[i][j] == 1 )
		{
			binaryMatrix[i][j] = 0;
			helper(rows,cols,i+1,j,binaryMatrix);
			helper(rows,cols,i-1,j,binaryMatrix);
			helper(rows,cols,i,j+1,binaryMatrix);
			helper(rows,cols,i,j-1,binaryMatrix);
		}
	}

	public static void main(String[] args) {
		int[][] binaryMatrix = new int[][] {{1}};
		System.out.println(Demo.getNumberOfIslands(binaryMatrix));
	}
}
