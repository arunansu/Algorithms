//Given undirected graph represented as Adjacent List using Array of ArrayList find number of 
//connected components
package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphUndirectedComponents {
	
	public static void explore(ArrayList<Integer>[] adj, Boolean[] visited, int v)
	{
		System.out.println(String.format("Visiting: " + String.valueOf(v)));
		visited[v] = true;
		for(int w : adj[v]){
			if(visited[w] == null || !visited[w]) {
				explore(adj, visited, w);
			}
		}
	}
	
	private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        Boolean[] visited = new Boolean[adj.length];
        System.out.println(visited[0]);
        for(int i = 0; i < adj.length; i++) {
        	if(visited[i] == null || !visited[i]) {
        		explore(adj, visited, i);
        		++result;
        		System.out.println(String.format("Component: " + String.valueOf(result)));
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
    //int n = scanner.nextInt();
    //int m = scanner.nextInt();
		int n = 5;
		int m = 7;
    ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
    for (int i = 0; i < n; i++) {
    	adj[i] = new ArrayList<Integer>();
    }
//    for (int i = 0; i < m; i++) {
//    	int x, y;
//      x = scanner.nextInt();
//      y = scanner.nextInt();
//      adj[x - 1].add(y - 1);
//      adj[y - 1].add(x - 1);
//    }
    adj[0].add(1);
    adj[0].add(4);
    adj[1].add(0);
    adj[1].add(4);
    adj[1].add(2);
    adj[1].add(3);
    adj[2].add(1);
    adj[2].add(3);
    adj[3].add(1);
    adj[3].add(4);
    adj[3].add(2);
    adj[4].add(3);
    adj[4].add(0);
    adj[4].add(1);
    System.out.println("Number of Components: " + String.valueOf(numberOfComponents(adj)));
	}

}
