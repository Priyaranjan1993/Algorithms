package DP;

import java.util.Arrays;

public class CoinChangeMin {
	public int coinChange(int[] coins, int amount) {

		int[] arr = new int[amount + 1];
		int[] track = new int[amount + 1];

		arr[0] = 0; track[0] = -1;

		for(int i=1 ; i <arr.length; i++)
		{
			arr[i] = Integer.MAX_VALUE - 1;
			track[i] = -1;
		}

		for(int m = 0; m< coins.length; m++)
		{
			for( int j =1; j <=amount; j++)
			{
				if(j >= coins[m])
				{
					arr[j] = Math.min(arr[j], arr[j - coins[m]]+1);
					track[j] = m; 
				}
			}
		}
		//track(coins,track);
		if(arr[amount] == Integer.MAX_VALUE - 1)
			return -1;
		else
			return arr[amount];

	}

	public void track(int[] coins, int[] track)
	{
		if(track[track.length - 1] == -1)
		{
			System.out.println("No Solution");
		}

		int start = track.length - 1;

		while(start != 0)
		{
			int val = track[start];
			System.out.println(coins[val]);
			start = start - coins[val];
		}
	}

	public static void main(String args[]) {
		CoinChangeMin c = new CoinChangeMin();
		int[] coins = new int[] {1,2,5};
		int amount = 11;
		System.out.println(c.coinChange(coins, amount));
	}
}
