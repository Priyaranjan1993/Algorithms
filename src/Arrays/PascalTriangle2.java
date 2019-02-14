package Arrays;
import java.util.*;

public class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if(rowIndex <= 0) return new ArrayList<Integer>() {{add(1);}};
		
		for(int i = 0; i <= rowIndex; i++)
		{
			result.add(0,1);
			
			for(int j = 1; j < result.size() - 1; j++)
			{
				result.set(j, result.get(j)+result.get(j+1));
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		PascalTriangle2 p = new PascalTriangle2();
		List<Integer> ls = p.getRow(0);
		for(int x : ls)
		{
			System.out.println(x);
		}
	}
}
