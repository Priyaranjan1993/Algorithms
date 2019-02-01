package DP;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		int[][] res = new int[coins.length + 1][amount + 1];
		res[0][0] = 1;

		for(int i = 1 ; i <res.length; i++)
		{
			for(int j = 0; j < res[0].length; j++)
			{
				if(j >= coins[i-1])
				{
					res[i][j] = res[i-1][j] + res[i][j - coins[i -1]];
				}
				else {
					res[i][j] = res[i-1][j];
				}
			}
		}

		return res[coins.length][amount];
	}

	public static void main(String args[]) {
		CoinChange2 c = new CoinChange2();
		int amount = 5;
		int[] coins = new int[] {1,2,5};
		System.out.println(c.change(amount, coins));
	}
}
