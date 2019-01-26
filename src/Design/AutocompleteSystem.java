package Design;

import java.util.*;

class Trie{
	Map<Character,Trie> children;
	Map<String,Integer> count;
	Trie(){
		children = new HashMap<>();
		count = new HashMap<>();
	}
}

class Pair{
	String s;
	int c;
	Pair(String s, int c){
		this.s = s;
		this.c = c;
	}
}

class customComp implements Comparator<Pair>{

	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.c == o2.c)
		{
			return o1.s.compareTo(o2.s);
		}
		else {
			return o2.c - o1.c;
		}
	}

}
public class AutocompleteSystem {
	Trie root;
	String prefix;
	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new Trie();
		prefix = "";
		for(int i=0; i< sentences.length;i++)
		{
			add(sentences[i],times[i]);
		}
	}

	public void add(String sentence, int times) {

		Trie curr = root;
		for(Character c : sentence.toCharArray())
		{
			Trie next = curr.children.get(c);
			if(next == null)
			{
				next = new Trie();
				curr.children.put(c, next);
			}
			curr = next;
			curr.count.put(sentence, next.count.getOrDefault(sentence, 0)+times);
		}
	}

	public List<String> input(char c) {
		if(c == '#')
		{
			add(prefix,1);
			prefix = "";
			return new ArrayList<>();
		}

		prefix = prefix + c;
		Trie curr = root;

		for(Character cc : prefix.toCharArray())
		{
			Trie next = curr.children.get(cc);
			if(next == null)
			{
				return new ArrayList<>();
			}
			curr = next;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(new customComp());
		for(String s : curr.count.keySet())
		{
			pq.add(new Pair(s, curr.count.get(s)));
		}
		List<String> ls = new ArrayList<>();
		for(int i = 0; i< 3 && !pq.isEmpty(); i++)
		{
			ls.add(pq.poll().s);
		}
		return ls;

	}
}
