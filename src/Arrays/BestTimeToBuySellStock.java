package Arrays;

public class BestTimeToBuySellStock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = Integer.MAX_VALUE;

		for(int i =0 ; i < prices.length; i++)
		{
			if(prices[i] < min)
			{
				min = prices[i];
			}
			else {
				profit = Math.max(profit, prices[i] - min);
			}
		}
		return profit;
	}

	public static void main(String args[]) {
		BestTimeToBuySellStock b = new BestTimeToBuySellStock();
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(b.maxProfit(prices));
	}
}
