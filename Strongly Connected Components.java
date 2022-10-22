// Kosaraju's algorithm to find strongly connected components in Java

import java.util.*;
import java.util.LinkedList;

class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	// Create a graph
	Graph(int s) {
		V = s;
		adj = new LinkedList[s];
		for (int i = 0; i < s; ++i)
			adj[i] = new LinkedList();
	}

  // Add edge
	void addEdge(int s, int d) {
		adj[s].add(d);
	}

	// DFS
	void DFSUtil(int s, boolean visitedVertices[]) {
		visitedVertices[s] = true;
		System.out.print(s + " ");
		int n;

		Iterator<Integer> i = adj[s].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visitedVertices[n])
				DFSUtil(n, visitedVertices);
		}
	}

	// Transpose the graph
	Graph Transpose() {
		Graph g = new Graph(V);
		for (int s = 0; s < V; s++) {
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(s);
		}
		return g;
	}

	void fillOrder(int s, boolean visitedVertices[], Stack stack) {
		visitedVertices[s] = true;

		Iterator<Integer> i = adj[s].iterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visitedVertices[n])
				fillOrder(n, visitedVertices, stack);
		}
		stack.push(new Integer(s));
	}

	// Print strongly connected component
	void printSCC() {
		Stack stack = new Stack();

		boolean visitedVertices[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visitedVertices[i] = false;

		for (int i = 0; i < V; i++)
			if (visitedVertices[i] == false)
				fillOrder(i, visitedVertices, stack);

		Graph gr = Transpose();

		for (int i = 0; i < V; i++)
			visitedVertices[i] = false;

		while (stack.empty() == false) {
			int s = (int) stack.pop();

			if (visitedVertices[s] == false) {
				gr.DFSUtil(s, visitedVertices);
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 0);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 7);

		System.out.println("Strongly Connected Components:");
		g.printSCC();
	}
}
