package DFS;

public class NumberOfConnectedComp {
	public int countComponents(int n, int[][] edges) {
		int count = n;
		int[] root = new int[n];
		for(int i=0 ; i< n; i++)
		{
			root[i] = i;
		}

		for(int k=0; k < edges.length; k++)
		{
			int rootX = findRoot(root,edges[k][0]);
			int rootY = findRoot(root,edges[k][1]);

			if(rootX != rootY)
			{
				count--;
				root[rootY] = rootX;
			}
		}
		return count;
	}

	private int findRoot(int[] root, int i) {
		while(root[i] != i)
		{
			root[i] = root[root[i]];
			i = root[i];
		}
		return i;
	}

	public static void main(String args[]) {
		NumberOfConnectedComp cc = new NumberOfConnectedComp();
		int n = 5;
		int[][] edges = new int[][] {{0, 1}, {1, 2}, {3, 4}};
		int res = cc.countComponents(n, edges);
		System.out.println(res);
	}
}
