package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		if(intervals.size() == 0)
		{
			return null;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start != o2.start)
				{
					return o1.start - o2.start;
				}
				else {
					return o1.end - o2.end;
				}
			}
		});

		ArrayList<Interval> arr = new ArrayList<>();

		Interval previous = intervals.get(0);

		for(int i=0; i<intervals.size();i++)
		{
			Interval current = intervals.get(i);
			if(current.start > previous.end)
			{
				arr.add(previous);
				previous = current;
			}
			else {
				Interval inv = new Interval(previous.start, Math.max(previous.end, current.end));
				previous = inv;
			}
		}
		arr.add(previous);

		return arr;
	}

	public static void main(String args[])
	{
		ArrayList<Interval> ar = new ArrayList<>();
		ArrayList<Interval> res = new ArrayList<>();
		ar.add(new Interval(1, 3));
		ar.add(new Interval(2, 6));
		ar.add(new Interval(8, 10));
		ar.add(new Interval(15, 18));

		MergeIntervals m = new MergeIntervals();
		res = (ArrayList<Interval>) m.merge(ar);
		System.out.println(res);
	}
}
