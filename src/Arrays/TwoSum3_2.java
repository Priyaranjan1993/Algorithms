package Arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author priya
 *	Find = O(n)
 *	Add = O(1)
 * Result = Accepted
 */
public class TwoSum3_2 {

	Map<Integer, Integer> map;
	public TwoSum3_2() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if(map.containsKey(number))
		{
			map.put(number, 2);
		}
		else {
			map.put(number, 1);
		}
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext())
		{
			int num1 = it.next();
			int num2 = value - num1;
			if(map.containsKey(num2))
			{
				if(num1 != num2 || map.get(num2) == 2)
				{
					return true;
				}
			}
		}
		return false;
	}
}
