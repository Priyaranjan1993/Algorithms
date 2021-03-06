package Arrays;

public class BestTimeToBuySellStock2 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for(int i = 1; i< prices.length; i++)
		{
			if(prices[i] > prices[i-1])
			{
				profit += prices[i] - prices[i-1];
			}
		}
		return profit;
	}
	
	public static void main(String args[])
	{
		BestTimeToBuySellStock2 b = new BestTimeToBuySellStock2();
		int[] prices = new int[] {1,5,7,100};
		b.maxProfit(prices);
	}
}
