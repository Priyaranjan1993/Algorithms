package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {


	public List<String> letterCombinations(String digits) {
		Map<Character,Character[]> map = new HashMap<>();
		map.put('2', new Character[] {'a','b','c'});
		map.put('3', new Character[] {'d','e','f'});
		map.put('4', new Character[] {'g','h','i'});
		map.put('5', new Character[] {'j','k','l'});
		map.put('6', new Character[] {'m','n','o'});
		map.put('7', new Character[] {'p','q','r','s'});
		map.put('8', new Character[] {'t','u','v'});
		map.put('9', new Character[] {'w','x','y','z'});
		List<String> result = new ArrayList<>();
		
		if(digits==null || digits == "" ||digits.length() == 0)
		{
			return result;
		}
		char[] array = new char[digits.length()];
		List<String> ls;
		ls = helper(digits,0,map,array, result);
		return ls;
	}

	public List<String> helper(String digits, int index, Map<Character, Character[]> map, char[] array, List<String> result) {
		
		if(index == digits.length())
		{
			result.add(new String(array));
			return result;
		}
		
		char c = digits.charAt(index);
		Character[] candidates = map.get(c);
		for(char ch : candidates)
		{
			array[index] = ch;
			helper(digits,index + 1, map, array,result);
		}
		
		return result;
	}

	public static void main(String args[])
	{
		LetterCombinationsOfPhoneNumber l = new LetterCombinationsOfPhoneNumber();
		String digits = "23";
		List<String> ls = l.letterCombinations(digits);
		for(String s : ls)
		{
			System.out.println(s);
		}
	}


}
