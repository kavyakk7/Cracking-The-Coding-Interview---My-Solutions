package CrackingTheCodingInterviewProblems;

import java.util.*;
/*
 * Given an array a;
 * find the median m[i] from a[0] through a[i]
 * 
 */

public class FindtheRunningMedianUsingHeaps {

	static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size() == 0 || lowers.peek() > number)
			lowers.add(number);
		else
			highers.add(number);
	}
	
	static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()? lowers : highers;
		PriorityQueue<Integer> smallerHeap= lowers.size() > highers.size()? highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >=2 ) {
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()? lowers : highers;
		PriorityQueue<Integer> smallerHeap= lowers.size() > highers.size()? highers : lowers;
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return (double)(biggerHeap.peek() + smallerHeap.peek())/2;
		}
		else
			return biggerHeap.peek();
	}
	
	static double[] getMedian(int[] array) {
		PriorityQueue<Integer> maxHeapOfLowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1*(a.compareTo(b));
			}
		});
		PriorityQueue<Integer> minHeapOfHighers = new PriorityQueue<Integer>();
		double[] medians = new double[array.length];
		for(int i = 0; i< array.length; i++) {
			int number = array[i];
			addNumber(number, maxHeapOfLowers, minHeapOfHighers);
			rebalance(maxHeapOfLowers, minHeapOfHighers);
			medians[i] = getMedian(maxHeapOfLowers, minHeapOfHighers);
		}
		return medians;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {6,3,5,1,2,8,4};
		double[] medians = getMedian(array);
		for(int i = 0 ; i< medians.length; i++)
			System.out.println(medians[i]);
	}

}
