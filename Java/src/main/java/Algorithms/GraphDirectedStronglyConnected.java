package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphDirectedStronglyConnected {
	
	private static ArrayList<Integer>[] reverseGraph(ArrayList<Integer>[] adj) {
		int n = adj.length;
		ArrayList<Integer>[] revGraph = (ArrayList<Integer>[])new ArrayList[n];
		for (int i = 0; i < n; i++) {
			revGraph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			for (int j : adj[i]) {
				revGraph[j].add(i);
			}
		}
		return revGraph;
	}

	private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        //write your code here
        return 0;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
	}

}
