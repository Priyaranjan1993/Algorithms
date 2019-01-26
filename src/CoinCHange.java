
public class CoinCHange {

	public int coinChange(int[] coins, int amount) {
		if(amount==0) return 0;

		int[] dp = new int [amount+1];
		dp[0]=0; // do not need any coin to get 0 amount
		for(int i=1;i<=amount; i++)
			dp[i]= Integer.MAX_VALUE;

		for(int i=0; i<=amount; i++){
			for(int coin: coins){
				if(i+coin <=amount){
					if(dp[i]==Integer.MAX_VALUE){
						dp[i+coin] = dp[i+coin];
					}else{
						dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
					}
				}
			}
		}

		if(dp[amount] >= Integer.MAX_VALUE)
			return -1;

		return dp[amount];
	}

	public static void main(String args[])
	{
		CoinCHange c = new CoinCHange();
		int amount = 11;
		int[] coins = new int []{1,2,5};
		int x = c.coinChange(coins, amount);
		System.out.println(x);
	}
}
