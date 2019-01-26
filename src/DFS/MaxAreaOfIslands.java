package DFS;

public class MaxAreaOfIslands {
	public int maxAreaOfIsland(int[][] grid) {

		if(grid==null || grid.length==0||grid[0].length==0)
			return 0;
		int max = 0;
		int m = grid.length;
		int n = grid[0].length;

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j]==1){
					max = Math.max(max , merge(grid, i, j));
				}
			}
		}

		return max;

	}

	public int merge(int[][] grid, int i, int j){
		int m=grid.length;
		int n=grid[0].length;

		if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==1)
		{
			grid[i][j]=0;

			return 1 +merge(grid, i-1, j)+
					merge(grid, i+1, j)+
					merge(grid, i, j-1)+
					merge(grid, i, j+1);
		}
		return 0;
	}
	
	public static void main(String args[]) {
		MaxAreaOfIslands m = new MaxAreaOfIslands();
		int[][] grid = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(m.maxAreaOfIsland(grid));
	}
}
