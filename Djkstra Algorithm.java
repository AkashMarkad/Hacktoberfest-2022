// Djkstra Algorithm 
// Djkstra Algorithm is most popular algorithm to find the shortest path from source to all nodes

// Apprioach 1: Using PriorityQueue Data structure we can find the minimum distance from the source 
// priorityqueue is useful because it will always give minimum element on the top

// Time Complexity - O((N+E)logN)
// Space Complexity - O(N)+O(N)

// Code:

import java.util.ArrayList;

class Node implements Comparator<Node>{
    int v;
    int w;
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    Node(){}
    int getV(){
        return v;
    }
    int getW(){
        return w;
    }
    
    @Override
    public int compare(Node node1, Node node2){
        if(node1.w>node2.w){
            return 1;
        }
        if(node1.w<node2.w){
            return -1;
        }
        return 0;
    }
    
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] findDjk(int S, ArrayList<ArrayList<Node>> adjN, int V){
        int dist[] = new int[V];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        Arrays.fill(dist,100000);
        dist[S]=0;
        pq.add(new Node(S,0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            for(Node it : adjN.get(n.getV())){
                if(dist[n.getV()]+it.getW()<dist[it.getV()]){
                    dist[it.getV()] = dist[n.getV()] + it.getW();
                    pq.offer(new Node(it.getV(),dist[it.getV()]));
                }
            }
        }
        return dist;
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        ArrayList<ArrayList<Node>> adjN = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjN.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                adjN.get(i).add(new Node(adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
            }
        }
        
        return findDjk(S,adjN,V);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();
        for(int i=0;i<4;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(2).add(0);
        int ans[] = dijkstra(V,graph);
        for(int i : ans) System.out.println(i);
    }
}

