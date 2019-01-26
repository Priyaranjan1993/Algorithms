package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	public int snakesAndLaddersFun(int[][] board) {
		int n = board.length;
		int[] barray = new int[n*n];
		int row = n -1;
		int col = 0;
		int index = 0;
		int inc = 1;
		while(index < n*n)
		{
			barray[index++] = board[row][col];
			if(inc == 1 && col == n-1)
			{
				inc = -1;
				row --;
			}
			else if(inc == -1 && col == 0)
			{
				inc = 1;
				row --;
			}
			else {
				col = col + inc;
			}
		}

		boolean track[] = new boolean[n*n];
		int min = 0;
		Queue<Integer> q = new LinkedList<>();
		int start = barray[0] > -1 ? barray[0] - 1: 0;
		q.offer(start);
		track[start] = true;

		while(!q.isEmpty())
		{
			int size = q.size();
			while(size > 0)
			{
				size--;
				int top = q.poll();
				if(top == n*n-1)
				{
					return min;
				}
				for(int k = top + 1 ; k<= Math.min(top + 6, n * n-1); k++)
				{
					int output = barray[k] > -1 ? barray[k] -1 : k;
					if(!track[output])
					{
						track[output] = true;
						q.offer(output);
					}
				}
			}
			min++;
		}
		return -1;
	}

	public static void main(String args[])
	{
		int[][] arr = new int[][] {{-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,35,-1,-1,13,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,15,-1,-1,-1,-1}};

			SnakesAndLadders s = new SnakesAndLadders();
			System.out.println(s.snakesAndLaddersFun(arr));
	}
}
