package CrackingTheCodingInterviewProblems;

public class CheckIfBinarySearchTree {
	
	class Node {
		int data;
		Node left;
		Node right;
	}
	boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST(Node root, int min, int max) {
		if(root == null)
			return true;
		if(root.data < min || root.data > max)
			return false;
		return checkBST(root.left, min, root.data - 1) && checkBST(root.right, max, root.data + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
