package Arrays;

public class FlippingAnImage {

	public int[][] flipAndInvertImage(int[][] A) {

		int len = A[0].length;
		for(int row[] : A)
		{
			for(int i = 0 ; i < len + 1/2; i++)
			{
				int temp = row[i] ^ 1;
				row[i] = row [len - 1 - i] ^ 1;
				row[len - 1 - i] = temp;

			}
		}
		return A;
	}
}
