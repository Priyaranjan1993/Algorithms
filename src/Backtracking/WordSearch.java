package Backtracking;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int rowL = board.length;
		int cowL = board[0].length;
		boolean[][] valid = new boolean[rowL][cowL];
		char[] str = word.toCharArray();

		for(int i = 0; i < rowL; i++)
		{
			for(int j=0 ; j < cowL; j++)
			{
				 if(isExist(board,i,j,str,0,valid))
					 return true;
			}
		}
		return false;
	}

	private boolean isExist(char[][] board, int rowL, int cowL, char[] str, int i, boolean[][] visited) {
		if(str.length == i)
		{
			return true;
		}
		
		int r = board.length;
		int c = board[0].length;
		if(rowL < 0 || cowL <0 || rowL >= r || cowL >= c || board[rowL][cowL] !=str[i])
			return false;
		if(!visited[rowL][cowL])
		{
			visited[rowL][cowL] = true;

			Boolean result =  isExist(board,  rowL + 1, cowL,     str,  i+1,    visited) ||
					isExist(board,  rowL - 1, cowL,     str,  i+1,    visited) ||
					isExist(board,  rowL,     cowL + 1, str,  i+1,    visited) ||
					isExist(board,  rowL,     cowL - 1, str,  i+1,    visited);
			
			visited[rowL][cowL] = false;
			return result;
		}
		return false;
	}
	public static void main(String args[]) {
		WordSearch w = new WordSearch();
		char[][] board = new char[][] {  {'C','A','A'},
			{'A','A','A'},
			{'B','C','D'}};
			String word = "AAB";
			boolean res = w.exist(board, word);
			System.out.println(res);
	}
}
