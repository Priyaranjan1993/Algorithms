package Graph;

import java.util.LinkedList;

public class UndirectedGraphCreation {
	LinkedList<Integer> l[];

	UndirectedGraphCreation(int nodes)
	{
		l = new LinkedList[nodes];
		for(int i=0; i<nodes; i++)
		{
			l[i] = new LinkedList<>();
		}
	}

	public void addEdge(UndirectedGraphCreation g, int src, int dest)
	{
		g.l[src].add(dest);
		g.l[dest].add(src);
	}

	public void display(UndirectedGraphCreation ug) {
		for(int i=0; i<ug.l.length; i++)
		{
			System.out.println("for vertex "+i);
			System.out.print("head");
			for(int x : ug.l[i])
			{
				System.out.print("---->");
				System.out.print(x);
			}
			System.out.println("\n");
		}
	}
	public static void main(String args[])
	{
		int nodes = 5;
		UndirectedGraphCreation ug = new UndirectedGraphCreation(nodes);
		ug.addEdge(ug, 0, 1);
		ug.addEdge(ug, 0, 4);
		ug.addEdge(ug, 1, 2);
		ug.addEdge(ug, 1, 3);
		ug.addEdge(ug, 1, 4);
		ug.addEdge(ug, 2, 3);
		ug.addEdge(ug, 3, 4);

		ug.display(ug);


	}


}
