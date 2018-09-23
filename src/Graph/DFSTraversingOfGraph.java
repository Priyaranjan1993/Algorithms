package Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DFSTraversingOfGraph {

	LinkedList<Integer> arr[];
	public DFSTraversingOfGraph(int size) {
		arr = new LinkedList[size];
		for(int i=0; i<size; i++)
		{
			arr[i] = new LinkedList<>();
		}
	}

	public void create(DFSTraversingOfGraph graph, int start, int end) {
		graph.arr[start].add(end);
		graph.arr[end].add(start);
	}

	public void DFS(DFSTraversingOfGraph graph, int index) {

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for(int i=0;i<graph.arr.length;i++)
		{
			if(visited.get(i) == null)
			{
				DFSUtil(i,visited,graph);
			}
		}

	}

	private void DFSUtil(int i, Map<Integer, Boolean> visited,DFSTraversingOfGraph graph) {
		visited.put(i, true);
		System.out.println(i);
		Iterator<Integer> it = graph.arr[i].iterator();
		while(it.hasNext())
		{
			int q = it.next();
			if(visited.get(q) == null)
				DFSUtil(q,visited,graph);
		}
	}

	public static void main(String args[])
	{
		int size = 5;
		DFSTraversingOfGraph graph = new DFSTraversingOfGraph(size);
		graph.create(graph, 0, 1);
		graph.create(graph, 0, 4);
		graph.create(graph, 1, 2);
		graph.create(graph, 1, 3);
		graph.create(graph, 1, 4);
		graph.create(graph, 2, 3);
		graph.create(graph, 3, 4);

		graph.DFS(graph, 0);
	}


}
