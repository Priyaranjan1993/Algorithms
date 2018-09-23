package Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSTraversingOfQueue {

	LinkedList<Integer> arr[];
	BFSTraversingOfQueue(int size)
	{
		arr = new LinkedList[size];
		for(int i=0; i< size; i++)
		{
			arr[i] = new LinkedList<>();
		}
	}

	public void create(BFSTraversingOfQueue graph, int start, int end) {
		graph.arr[start].add(end);
		graph.arr[end].add(start);
	}
	
	public void display(BFSTraversingOfQueue ug) {
		for(int i=0; i<ug.arr.length; i++)
		{
			System.out.println("for vertex "+i);
			System.out.print("head");
			for(int x : ug.arr[i])
			{
				System.out.print("---->");
				System.out.print(x);
			}
			System.out.println("\n");
		}
	}

	private void searchInBFS(int i, int size, BFSTraversingOfQueue graph) {

		/*boolean visited[] = new boolean[size];*/
		Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
		LinkedList<Integer> queue = new LinkedList<Integer>();

		map.put(i, true);
		queue.add(i);

		while(!queue.isEmpty())
		{
			System.out.println(queue.peek());
			int element = queue.pop();
			Iterator<Integer> it= graph.arr[element].iterator();
			while(it.hasNext())
			{
				int n = it.next();
				if(map.get(n) == null)
				{
					map.put(n,true);
					queue.add(n);
				}

			}
		}
		
		for(int k=0; k<graph.arr.length;k++)
		{
			if(map.get(k) == null)
			{
				searchInBFS(k,graph.arr.length,graph);
			}
		}


	}

	public static void main(String args[])
	{
		int size = 5;
		BFSTraversingOfQueue bfs = new BFSTraversingOfQueue(size);
		bfs.create(bfs, 0, 1);
		bfs.create(bfs, 0, 4);
		bfs.create(bfs, 1, 2);
		bfs.create(bfs, 1, 3);
		bfs.create(bfs, 1, 4);
		bfs.create(bfs, 2, 3);
		bfs.create(bfs, 3, 4);

		bfs.searchInBFS(0,size,bfs);
		//bfs.display(bfs);
	}

}
