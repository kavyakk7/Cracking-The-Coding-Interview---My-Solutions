package CrackingTheCodingInterviewProblems;

import java.util.*;
/*
 * given two words, check how many characters to cancel out from each word 
 * for the two words to be an anagram.
 * word1 = hello, word2 = billion
 * anagram = llo
 * number of characters to cancel out = 6
 * 
 */
public class AnagramProblem {
	
	/// My Solution
	static int anagram(String w1, String w2) {
		int l1 = w1.length();
		int l2 = w2.length();
		int count = 0;
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();		
		for(int i = 0 ; i < l2; i++) {
			if(ht.containsKey(w2.charAt(i)))
				ht.put(w2.charAt(i), ht.get(w2.charAt(i))+1);
			else
				ht.put(w2.charAt(i), 1);
		}
		for(int i = 0; i < l1; i++) {
			if(ht.containsKey(w1.charAt(i)))
				ht.put(w1.charAt(i), ht.get(w1.charAt(i))-1);
			else
				ht.put(w1.charAt(i), 1);
		}
		Set<Character> keys = ht.keySet();
		for(Character key : keys) {
			System.out.println(key+" : "+ht.get(key));
			count+=ht.get(key);
		}
		return count;
	}
	
	///// Author's solution:
	public static int NUMBER_LETTERS = 26;
	
	public static int getDifference(int[] c1, int[] c2) {
		int delta = 0;
		for(int i = 0; i< c1.length; i++) {
			int diff = Math.abs(c1[i] - c2[i]);
			delta += diff;
		}
		return delta;
	}
	
	public static int[] getCharCount(String word) {
		int[] charCount = new int[NUMBER_LETTERS];
		int offset = (int) 'a';
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int code = c - offset;
			charCount[code]++;
		}
		return charCount;
	}
	
	public static int numberNeeded(String w1, String w2) {
		int[] charCount1 = getCharCount(w1);
		int[] charCount2 = getCharCount(w2);
		return getDifference(charCount1, charCount2);
	}
	
	/// Driver 
	public static void main(String[] args) {
		String word1 = "hello", word2 = "billion";
		int number1 = anagram(word1,word2);
		System.out.println(number1);
		int number2 = numberNeeded(word1,word2);
		System.out.println(number2);
	}
}
