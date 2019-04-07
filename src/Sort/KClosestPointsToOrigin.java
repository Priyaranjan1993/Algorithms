package Sort;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2) -> p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1]);
		for (int[] p : points) {
			pq.offer(p);
			if (pq.size() > K) {
				pq.poll();
			}
		}
		int[][] res = new int[K][2];
		while (K > 0) {
			res[--K] = pq.poll();
		}
		return res;
	}

	public static void main(String args[])
	{
		
		KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
		int K = 2;
		int[][] points = new int[][] {{3,3},{5,-1},{-2,4}};
		int[][] res = obj.kClosest(points, K);
		for(int[] r : res)
		{
			System.out.println("***************");
			System.out.println(r[0]);
			System.out.println(r[1]);
		}
	}
}
