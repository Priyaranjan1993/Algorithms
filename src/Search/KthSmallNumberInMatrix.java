package Search;

import java.util.PriorityQueue;

public class KthSmallNumberInMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for(int j = 0; j <= n-1; j++) 
			pq.offer(new Tuple(0, j, matrix[0][j]));
		for(int i = 0; i < k-1; i++) {
			Tuple t = pq.poll();
			if(t.x == n-1) 
				continue;
			pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
		}
		return pq.poll().val;
	}

	public static void main(String args[])
	{
		KthSmallNumberInMatrix s = new KthSmallNumberInMatrix();
		int [][] matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
		int k = 8;
		int result = s.kthSmallest(matrix, k);
		System.out.println(result);
	}
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;
	public Tuple (int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo (Tuple that) {
		return this.val - that.val;
	}
}
