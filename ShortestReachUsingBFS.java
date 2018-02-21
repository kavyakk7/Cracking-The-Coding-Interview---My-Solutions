package CrackingTheCodingInterviewProblems;

import java.util.*;

import CrackingTheCodingInterviewProblems.CheckIfBinarySearchTree.*;

public class ShortestReachUsingBFS {
	/*
	 * Implementation of a graph and node class foes here
	 */
	class Node {
		int data;
		int[] neighbours;
	}
	
	private static int EDGE_DISTANCE = 6;
	private Node[] nodes;
	
	// shortest reach using BFS:
	public int[] shortestReach(int startid) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(startid);
		
		int[] distances = new int[nodes.length];
		Arrays.fill(distances, -1);
		distances[startid] = 0;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int neighbour : nodes[node].neighbours) {
				if(distances[neighbour] == -1) {
					distances[neighbour] = distances[node] + EDGE_DISTANCE;
					queue.add(neighbour);
				}
			}
		}		
		return distances;
	}

}
