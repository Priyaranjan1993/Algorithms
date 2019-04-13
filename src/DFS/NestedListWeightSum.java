package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author priya
 * NestedInteger is not coded. Not sure how it would be implemented as per leetcode problem. Leetcode handles that. Algo is written here.
 */
public class NestedListWeightSum {
/*	public int depthSum(List<NestedInteger> nestedList) {
		if(nestedList == null)
		{
			return 0;
		}
		
		int sum = 0;
		int level = 1;
		Queue<NestedInteger> queue = new LinkedList<>(nestedList);
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			
			for(int i =0; i < size; i++)
			{
				NestedInteger n = queue.poll();
				if(n.isInteger())
				{
					sum = sum + n.getInteger()*level;
				}
				else {
					queue.addAll(n.getList());
				}
			}
			
			level++;
		}
		
		return sum;
	}*/
}
