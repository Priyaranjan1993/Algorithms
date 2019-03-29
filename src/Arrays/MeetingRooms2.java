package Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
	public int minMeetingRooms(Interval[] intervals) {

		if(intervals == null || intervals.length == 0)
		{
			return 0;
		}

		Arrays.sort(intervals, (a,b) -> a.start - b.start);
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		queue.add(intervals[0].end);

		for(int i = 1; i < intervals.length ; i++)
		{
			if(intervals[i].start >= queue.peek())
			{
				queue.poll();
			}

			queue.add(intervals[i].end);
		}

		return queue.size();

	}
}
