package Trie;

import java.util.HashMap;
import java.util.Map;

class Trie
{
	boolean isWord;
	Map<Character, Trie> children;

	Trie(){
		children = new HashMap<>();
	}
}

public class ImplementTrie {
	Trie root;

	/** Initialize your data structure here. */
	public ImplementTrie() {
		root = new Trie();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie curr = root;
		char[] wordArray = word.toCharArray();

		for(int i=0; i < wordArray.length; i++)
		{
			char c = wordArray[i];
			if(!curr.children.containsKey(c))
			{
				curr.children.put(c, new Trie());
			}
			curr = curr.children.get(c);
		}
		curr.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie curr = root;
		char[] wordArray = word.toCharArray();
		for(int i=0; i < wordArray.length; i++)
		{
			char c = wordArray[i];
			if(curr.children.containsKey(c))
			{
				curr = curr.children.get(c);
			}
			else {
				return false;
			}
		}

		return curr.isWord;

	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Trie curr = root;
		char[] wordArray = prefix.toCharArray();
		for(int i=0; i < wordArray.length; i++)
		{
			char c = wordArray[i];
			if(curr.children.containsKey(c))
			{
				curr = curr.children.get(c);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		ImplementTrie trie = new ImplementTrie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}
}
