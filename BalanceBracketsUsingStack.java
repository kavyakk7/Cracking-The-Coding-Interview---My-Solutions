package CrackingTheCodingInterviewProblems;

import java.util.*;

public class BalanceBracketsUsingStack {

	public static char[][] TOKENS = {{'(',')'}, {'{','}'}, {'[',']'}};
	
	public static boolean matches(char openTerm, char closeTerm) {
		for(char[] array : TOKENS) {
			if(array[0] == openTerm)
				return array[1] == closeTerm;
		}
		return false;
	}
	
	public static boolean isBalanced(String expression) {
		Stack<Character> st = new Stack<Character>();
		char[] brackets = expression.toCharArray();
		for(int i = 0; i < brackets.length; i++) {
			if(brackets[i] == TOKENS[0][0] || brackets[i] == TOKENS[1][0] || brackets[i] == TOKENS[2][0])
				st.push(brackets[i]);
			else {
				if(st.isEmpty() || !matches(st.pop(), brackets[i]))
					return false;				
			}		
		}
		if(st.isEmpty())
			return true;		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
