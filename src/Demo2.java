import java.util.*;
public class Demo2 {
	int minimumGeneticMutation(String startStr, String endStr, String[] bank) {

	    Set<String> reached = new HashSet<String>();
	    reached.add(startStr);
	    int dis = 0;
	    List<String> bankList = new ArrayList<>();
	    for(int a=0; a<bank.length; a++)
	    {
	    	bankList.add(bank[a]);
	    }
	    
	    while(!reached.contains(endStr))
	    {
	        Set<String> tAdd = new HashSet<>();
	        for(String str : reached)
	        {
	            for(int i = 0; i < str.length(); i++)
	            {
	                char[] charArray = str.toCharArray();
	                for(char ch = 'A'; ch <= 'Z'; ch++)
	                {
	                    charArray[i] = ch;
	                    String word = new String(charArray);
	                    {
	                    	/*if(word.equalsIgnoreCase("AACCGGTA") || word.equalsIgnoreCase("AACCGCTA"))
	                    	{
	                    		System.out.println(word);
	                    	}*/
	                        if(bankList.contains(word))
	                        {
	                          tAdd.add(word);
	                          bankList.remove(word);
	                        }
	                    }
	                }
	            }
	        }
	        dis++;
	        if(tAdd.size() == 0)
	            return -1;
	        reached = tAdd;
	    }
	    return dis;
	}
	
	public static void main(String args[])
	{
		Demo2 d = new Demo2();
		String startStr = "AACCGGTT";
		String endStr = "AACCGGTA";
		String[] bank = new String[] {};
		System.out.println(d.minimumGeneticMutation(startStr, endStr, bank));
		
	}
}
