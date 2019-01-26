package BFS;

import java.util.*;

class Word{
	String s;
	int steps;

	Word(String s , int steps){
		this.s  = s;
		this.steps = steps;
	}
}

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(beginWord, 1));

		while(!queue.isEmpty())
		{
			Word pop = queue.poll();
			if(pop.s.equals(endWord))
			{
				return pop.steps;
			}

			char[] ch = pop.s.toCharArray();
			for(int i = 0; i< ch.length; i++)
			{
				for(char c = 'a'; c <= 'z'; c++)
				{
					char temp = ch[i];
					if(ch[i] != c)
					{
						ch[i] = c;
					}

					String str = new String(ch);
					if(wordList.contains(str))
					{
						queue.add(new Word(str, pop.steps + 1));
						wordList.remove(str);
					}

					ch[i] = temp;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(w.ladderLength(beginWord, endWord, wordList));
	}
}
