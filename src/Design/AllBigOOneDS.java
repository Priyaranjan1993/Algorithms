package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllBigOOneDS {

	Bucket head;
	Bucket tail;
	Map<String, Integer> stringMap;
	Map<Integer, Bucket> bucketMap;	
	/** Initialize your data structure here. */
	public AllBigOOneDS() {
		head = new Bucket(Integer.MIN_VALUE);
		tail = new Bucket(Integer.MAX_VALUE);
		stringMap = new HashMap<>();
		bucketMap = new HashMap<>();
		head.next = tail;
		tail.prev = head;
	}

	class Bucket{
		int val;
		Bucket next;
		Bucket prev;
		Set<String> keySet;
		Bucket(int val){
			this.val = val;
			keySet = new HashSet<>();
		}
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if(stringMap.containsKey(key))
		{
			helper(key,1);
		}
		else {
			stringMap.put(key, 1);
			if(head.next.val != 1)
			{
				arrangeBucket(new Bucket(1),head);
			}
			head.next.keySet.add(key);
			bucketMap.put(1, head.next);
		}
	}

	private void helper(String key, int i) {
		int count = stringMap.get(key);
		stringMap.put(key, count + i);
		Bucket currentBucket = bucketMap.get(count);
		Bucket newBucket;
		if(bucketMap.containsKey(count + i))
		{
			newBucket = bucketMap.get(count + i);
		}
		else {
			newBucket = new Bucket(count + i);
			bucketMap.put(count + i, newBucket);
			arrangeBucket(newBucket,currentBucket);
		}
		newBucket.keySet.add(key);
		currentBucket.keySet.remove(key);
		if(currentBucket.keySet.size() == 0)
		{
			removeBucketFromList(currentBucket);
			bucketMap.remove(currentBucket.val);
		}

	}

	private void removeBucketFromList(Bucket currentBucket) {
		currentBucket.prev.next = currentBucket.next;
		currentBucket.next.prev = currentBucket.prev;
		currentBucket.next = null;
		currentBucket.prev = null;
	}

	private void arrangeBucket(Bucket bucket, Bucket prevBucket) {
		bucket.prev = prevBucket;
		bucket.next = prevBucket.next;
		prevBucket.next.prev = bucket;
		prevBucket.next = bucket;
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if(stringMap.containsKey(key))
		{
			int count = stringMap.get(key);
			if(count == 1)
			{
				stringMap.remove(key);
				Bucket buck = bucketMap.get(count);
				buck.keySet.remove(key);
				if(buck.keySet.size() == 0)
				{
					removeBucketFromList(buck);
					bucketMap.remove(count);
				}
			}
			else {
				helper(key, -1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return tail.prev == head ? "" : (String)tail.prev.keySet.iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return  head.next == tail ? "" : (String)head.next.keySet.iterator().next();
	}
	
	public static void main(String args[])
	{
		AllBigOOneDS all = new AllBigOOneDS();
		all.inc("hello");
		all.getMaxKey();
		all.getMinKey();
	}
}
