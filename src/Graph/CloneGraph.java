package Graph;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}


public class CloneGraph {
	Map<Integer , UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		UndirectedGraphNode clone = cloneUtil(node);
		return clone;
	}
	private UndirectedGraphNode cloneUtil(UndirectedGraphNode node) {
		if(node == null)
		{
			return null;
		}

		if(map.containsKey(node.label))
		{
			return map.get(node.label);
		}

		UndirectedGraphNode gnode = new UndirectedGraphNode(node.label);

		map.put(node.label, gnode);

		for(UndirectedGraphNode u : node.neighbors)
		{
			gnode.neighbors.add(cloneUtil(u));
		}

		return gnode;
	}
}
