package CrackingTheCodingInterviewProblems;

import java.util.*;

public class MakeChangeFromMoneyUsingMemoization {

	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}
	
	private static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		// base cases
		if(money == 0) {
			return 1;
		}
		if(index >= coins.length) {
			return 0;
		}
		// creating memo
		String key = money + "-" + index;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		//algorithm starts
		int amountWithCoin = 0;
		long ways = 0;
		
		while(amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins, remaining, index + 1, memo);
			amountWithCoin += coins[index];
		}
		
		memo.put(key, ways);
		return ways;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
