package LinkedList;

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int w1 = -1;
		int w2 = -1;
		int minDistance = words.length;

		for(int i=0; i < words.length; i++)
		{
			if(words[i].equals(word1))
			{
				w1 = i;
			}

			else if(words[i].equals(word2))
			{
				w2 = i;
			}

			if(w1 != -1 && w2 != -1)
				minDistance = Math.min(minDistance, Math.abs(w1-w2));
		}
		return minDistance;
	}

	public static void main(String args[])
	{
		ShortestWordDistance s = new ShortestWordDistance();
		String[] arr = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		int distance = s.shortestDistance(arr, "coding", "makes");
		System.out.println(distance);
	}
}
