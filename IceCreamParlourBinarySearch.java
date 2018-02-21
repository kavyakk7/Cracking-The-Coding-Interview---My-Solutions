package CrackingTheCodingInterviewProblems;

import java.util.*;

public class IceCreamParlourBinarySearch {

	public static int getIndex(int[] menu, int value, int excludeThisValue) {
		for(int i = 0; i < menu.length; i++) {
			if(menu[i] == value && i != excludeThisValue)
				return i;
		}
		return -1;
	}
	
	public static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
		int index1 = getIndex(menu, value1, -1);
		int index2 = getIndex(menu, value2, value1);
		int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
		return indices;
	}
	
	public static int[] findChoices(int[] menu, int money) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		
		for(int i = 0; i < sortedMenu.length; i++) {
			int complement = sortedMenu[i] - money;
			int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
			if(location <= 0 && location > sortedMenu.length && sortedMenu[location] == complement) {
				int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
				return indices;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
