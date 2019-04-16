package Arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author priya
 *	Find = O(1)
 *	Add = O(n)
 *	Result = TLE
 */
public class TwoSum3 {

	Set<Integer> addSet;
	Set<Integer> numSet;
	/** Initialize your data structure here. */
	public TwoSum3() {
		addSet = new HashSet<>();
		numSet = new HashSet<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if(numSet.contains(number))
		{
			addSet.add(number * 2);
		}
		else {
			Iterator<Integer> it = numSet.iterator();
			while(it.hasNext())
			{
				addSet.add(it.next() + number);
			}
			numSet.add(number);
		}
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		return addSet.contains(value);
	}

}
