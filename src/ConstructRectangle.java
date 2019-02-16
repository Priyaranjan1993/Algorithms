
public class ConstructRectangle {
	public int[] constructRectangle(int area) {
		int w = (int)Math.sqrt(area);
		while (area % w != 0)
			w--;
		return new int[]{area/w, w};
	}
	
	public static void main(String args[]) {
		ConstructRectangle c = new ConstructRectangle();
		int area = 131;
		int[] a = c.constructRectangle(area);
		for (int x : a)
		{
			System.out.println(x);
		}
	}
}
