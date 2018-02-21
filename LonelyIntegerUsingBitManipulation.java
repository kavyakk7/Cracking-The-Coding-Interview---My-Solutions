package CrackingTheCodingInterviewProblems;

/*
 * Consider an array = [1,2,3,2,3,4,4,5,7,7,6]
 * here the lonely integer is 1, since it appears only once while others appear twice.
 * 
 * convert every int to its bit type, xor bit cooresponding to bit of others,
 * surprisingly, u derive the bit of the integer that is lonely.
 */
public class LonelyIntegerUsingBitManipulation {

	static int lonelyInteger(int[] arr) {
		int result = 0;
		for(int value : arr) {
			result ^= value;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,2,3,3,4,5,6,6,5,4,1,7};
		System.out.println(lonelyInteger(array));
	}
}
