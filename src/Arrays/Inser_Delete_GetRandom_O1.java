package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Inser_Delete_GetRandom_O1 {

	Map<Integer, Integer> map;
	List<Integer> arr;
	Random random;
	/** Initialize your data structure here. */
	public Inser_Delete_GetRandom_O1() {
		map = new HashMap<>();
		arr = new ArrayList<>();
		random = new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val))
		{
			return false;
		}
		arr.add(val);
		map.put(val, arr.size() - 1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val))
		{
			return false;
		}
		int index = map.get(val);

		//Collections.swap(arr, index, arr.size() - 1);
		if(index < arr.size() -1)
		{
			int last = arr.get(arr.size() - 1);
			arr.set(index,last);
			map.put(last, index);
		}

		map.remove(val);
		arr.remove(arr.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return arr.get(random.nextInt(arr.size()));
	}
}
