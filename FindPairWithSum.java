package CrackingTheCodingInterviewProblems;

import java.util.*;

public class FindPairWithSum {

	public static boolean hasPairWithSum(int[] arr, int sum) {
		HashSet<Integer> ht = new HashSet<Integer>();
		for(int i = 0 ; i < arr.length ; i++) {
			if(ht.contains(sum - arr[i])) {
				return true;
			}
			ht.add(sum - arr[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,4};
		int sum = 8;
		
		System.out.println(hasPairWithSum(arr, sum));
	}

}
