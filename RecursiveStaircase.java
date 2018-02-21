package CrackingTheCodingInterviewProblems;
/*
 * For more info on the problem,
 * watch https://www.youtube.com/watch?v=eREiwuvzaUM&list=PLOuZYwbmgZWXvkghUyMLdI90IwxbNCiWK&index=25
 */
public class RecursiveStaircase {

	/*
	 * Using Memoization
	 */
	public static int countPathUsingMemo(int steps) {
		if(steps < 0)
			return 0;
		return countPathsUsingMemo(steps, new int[steps + 1]);
	}
	public static int countPathsUsingMemo(int steps, int[] memo) {
		if(steps < 0)
			return 0;
		else if(steps == 0)
			return 1;
		if(memo[steps] == 0)
			memo[steps] = countPathsUsingMemo(steps - 1, memo) + countPathsUsingMemo(steps - 2, memo) + countPathsUsingMemo(steps - 3, memo);
		return memo[steps];
	}
	
	/*
	 * Using Dynamic Programming
	 */
	public static int countPathUsingDynamicProgramming(int steps) {
		if(steps < 0)
			return 0;
		else if(steps <= 1)
			return 1;
		int[] paths = new int[steps + 1];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;
		for(int i = 0 ; i <= steps; i++) {
			paths[i] = paths[i-1] + paths[i-2] + paths[i-3];
		}
		return paths[steps];
	}
	
	/*
	 * Using Iteration
	 */
	public static int countPathUsingIeration(int steps) {
		if(steps < 0)
			return 0;
		else if(steps <= 1)
			return 1;
		int[] paths = {1,1,2};
		for(int i = 0 ; i <= steps; i++) {
			int count = paths[2] + paths[1] + paths[0];
			paths[0] = paths[1];
			paths[1] = paths[2];
			paths[2] = count;
		}
		return paths[2];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
