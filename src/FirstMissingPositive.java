
public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] >= n)
					break;
				if(A[i]==A[A[i]-1])
					break;
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}
		for (int i = 0; i < n; i++){
			if (A[i] != i + 1){
				return i + 1;
			}
		}
		return n + 1;
	}
	
	public static void main(String args[])
	{
		FirstMissingPositive f = new FirstMissingPositive();
		int[] arr = new int[] {3,4,-1,1};
		int x = f.firstMissingPositive(arr);
		System.out.println(x);
	}
}
