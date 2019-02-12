package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


//Airplane seat arrangement problem

class PageRenderTime
{
	public int pageId;
	public double renderTime;
	public PageRenderTime(int id, double value)
	{
		this.pageId = id;
		this.renderTime = value;
	}
}

class customComp implements Comparator<PageRenderTime>
{

	@Override
	public int compare(PageRenderTime o1, PageRenderTime o2) {
		// TODO Auto-generated method stub
		//System.out.println(o1.pageId);
		//System.out.println(o2.pageId);
		int res = o1.pageId - o2.pageId;
		//System.out.println("comp ******* "+res);
		//System.out.println("-----------------------------------");
		if(res == 0)
		{
			/*Double d1 = new Double(o1.renderTime);
			Double d2 = new Double(o2.renderTime);*/
			//System.out.println(o2.renderTime);
			//System.out.println(o1.renderTime);
			int x = Double.compare(o2.renderTime, o1.renderTime);
			//System.out.println("==========  "+x);
			return x;
			
			//int d = Double.compare(o2.renderTime, o1.renderTime);
		}
		return res;
/*		int d = Double.compare(o2.renderTime, o1.renderTime);
		return d;*/
	}

}

public class Demo {

	Map<Integer,Double> calculateHighestFive(int renderCount, List<PageRenderTime> renderTimeOfPages)
	{
		PriorityQueue<PageRenderTime> pq = new PriorityQueue<>(new customComp());
		for(PageRenderTime p : renderTimeOfPages)
		{
			pq.offer(p);
		}

		while(pq.size()!=0)
		{
			PageRenderTime q = pq.poll();
			System.out.println(q.pageId+ " "+q.renderTime );
		}

		return null;

	}

	public static void main(String args[])
	{
		Demo d = new Demo();
		int x = 5;
		List<PageRenderTime> ls = new ArrayList<>();
		PageRenderTime p1 = new PageRenderTime(1, 40);
		PageRenderTime p2 = new PageRenderTime(1, 90);
		PageRenderTime p3 = new PageRenderTime(1, 30);
		PageRenderTime p4 = new PageRenderTime(1, 100);
		PageRenderTime p5 = new PageRenderTime(1, 120);
		PageRenderTime p6 = new PageRenderTime(1, 10);
		PageRenderTime p7 = new PageRenderTime(1, 5);

		PageRenderTime p8 = new PageRenderTime(2, 40);
		PageRenderTime p9 = new PageRenderTime(2, 90);
		PageRenderTime p10 = new PageRenderTime(2, 30);
		PageRenderTime p11 = new PageRenderTime(2, 100);
		PageRenderTime p12 = new PageRenderTime(2, 120);
		PageRenderTime p13 = new PageRenderTime(2, 10);
		PageRenderTime p14 = new PageRenderTime(2, 5);

		ls.add(p1);
		ls.add(p2);
		ls.add(p3);
		ls.add(p4);
		ls.add(p5);
		ls.add(p6);
		ls.add(p7);
		ls.add(p8);
		ls.add(p9);
		ls.add(p10);
		ls.add(p11);
		ls.add(p12);
		ls.add(p13);
		ls.add(p14);

		d.calculateHighestFive(x,ls);
	}
}

