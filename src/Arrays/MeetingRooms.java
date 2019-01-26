package Arrays;

import java.util.Arrays;

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {

		if(intervals == null)
			return false;

		Arrays.sort(intervals, (i1,i2) -> i1.start - i2.start);

		for(int i = 1; i< intervals.length; i++)
		{
			if(intervals[i].start < intervals[i - 1].end)
			{
				return false;
			}
		}
		return true;
	}
}
