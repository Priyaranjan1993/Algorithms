package Strings;

import java.util.*;
import java.util.Comparator;

public class ReOrderLogFiles {
	public String[] reorderLogFiles(String[] logs) {

		List<String> digitLogs = new ArrayList<>();
		PriorityQueue<String> letterQueue = new PriorityQueue<String>(new LetterComparator());

		List<String> results = new ArrayList<String>();

		for(String log: logs) {
			if(isDigitLog(log)) {
				digitLogs.add(log);
			} else {
				letterQueue.offer(log);
			}
		}

		// toArray on priority queue wouldnt guarantee retrieval order.
		while(letterQueue.size() != 0) {
			results.add(letterQueue.poll());
		}

		// Adding from an arraylist guarantees iterator order
		results.addAll(digitLogs);
		return results.toArray(new String[results.size()]);
	}


	private boolean isDigitLog(String logLine) {
		return Character.isDigit(logLine.charAt(logLine.indexOf(' ') + 1));
	}
	public class LetterComparator implements Comparator<String> {
		public int compare(String str1, String str2) {

			int spaceIndex1 = str1.indexOf(' ');
			int spaceIndex2 = str2.indexOf(' ');

			String word1 = str1.substring(spaceIndex1+1);
			String word2 = str2.substring(spaceIndex2+1);

			int compareStatus = word1.compareTo(word2);
			if(compareStatus == 0) {
				String identifier1 = str1.substring(0, spaceIndex1);
				String identifier2 = str2.substring(0, spaceIndex2);
				return (identifier2.compareTo(identifier1));
			}
			return compareStatus;
		}
	}

	public static void main(String[] args)
	{
		ReOrderLogFiles r = new ReOrderLogFiles();
		String[] logs = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] res = r.reorderLogFiles(logs);
		for(String s : res)
		{
			System.out.println(s);
		}
	}
}
