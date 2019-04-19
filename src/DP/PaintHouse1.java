package DP;

public class PaintHouse1 {
	public int minCost(int[][] costs) {

		int red = 0;
		int blue = 0;
		int green = 0;
		int rr,bb,gg;
		int n = costs.length;
		for(int i =0; i < n ; i++)
		{
			rr = red;
			bb = blue;
			gg = green;
			red = costs[i][0] + Math.min(gg,bb);
			blue = costs[i][1] + Math.min(rr,gg);
			green = costs[i][2] + Math.min(rr,bb);
		}
		return Math.min(Math.min(red, blue),green);
	}
}
