package Arrays;

public class BestTimeToBuySellStock4 {
/*	public int maxProfit(int k, int[] prices) {

		if(k == 0 || prices.length == 0)
		{
			return 0;
		}
		int[][] grid = new int[k+1][prices.length];

		for(int q=0; q < prices.length; q++)
		{
			grid[0][q] = 0;
		}

		for(int w=0; w < k+1; w++)
		{
			grid[w][0] = 0;
		}

		for(int i = 1 ; i< grid.length; i++)
		{
			for(int j=1; j < grid[0].length ; j++)
			{
				int maxVal = 0;
				for(int m =0 ; m < j ; m++)
				{
					maxVal = Math.max(maxVal, prices[j]-prices[m] + grid[i-1][m]);
				}
				grid[i][j] = Math.max(grid[i][j-1], maxVal);
			}
		}
		int result = grid[k][prices.length - 1];
		return result;
	}*/
	
	
	public int maxProfit(int k, int[] prices) {

		if(k == 0 || prices.length == 0)
		{
			return 0;
		}
		int[][] grid = new int[k+1][prices.length];

		for(int q=0; q < prices.length; q++)
		{
			grid[0][q] = 0;
		}

		for(int w=0; w < k+1; w++)
		{
			grid[w][0] = 0;
		}

		for(int i = 1 ; i< grid.length; i++)
		{
			int maxDiff = -prices[0];
			for(int j=1; j < grid[0].length ; j++)
			{
				grid[i][j] = Math.max(grid[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, grid[i-1][j]-prices[j]);
			}
		}
		int result = grid[k][prices.length - 1];
		return result;
	}

	public static void main(String[] args)
	{
		BestTimeToBuySellStock4 b = new BestTimeToBuySellStock4();
		int[] prices = {6,1,3,2,4,7};
		int  k =2 ;
		System.out.println(b.maxProfit(k, prices));
	}
}
