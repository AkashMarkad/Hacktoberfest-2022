// MST Using Kruskals Algorithm 

// Approach :

// Algorithm: For Implementing Kruskal's Algorithm We use Disjoint Data Structure
// Intuation : We peek the the minimum weight edge frist if the edge belonging the different component then we pick else we not pick it
// So the checking its belogs the same components or not we use Disjoint set Data Structure

// Time Complexity - O(MlogN)
// Space Complexity - O(N)+O(N)+O(N)

// Code:

class Node implements Comparator<Node>{
    int u,v,w;
    Node(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
    Node(){}
    
    @Override 
    public int compare(Node n1, Node n2){
        if(n1.w>n2.w){
            return 1;
        }
        if(n1.w<n2.w){
            return -1;
        }
        return 0;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    
    static int findPar(int u, int parent[]){
        if(u==parent[u]) return u;
        return parent[u]=findPar(parent[u],parent);
    }
    
    static void union(int u, int v, int parent[], int rank[]){
        u = findPar(u, parent);
        v = findPar(v, parent);
        if(rank[u]<rank[v]){
            parent[u] = v;
        }
        else if(rank[v]<rank[u]){
            parent[v] = u;
        }
        else{
            parent[v] = u;
            rank[u]++;
        }
    }
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        // System.out.println(adj);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                pq.add(new Node(i,adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
            }
        }
        int parent[] = new int[V];
        int rank[] = new int[V];
        for(int i=0;i<V;i++) parent[i]=i;
        int cost=0;
        while(!pq.isEmpty()){
            
            Node it  = pq.poll();
            if(findPar(it.u, parent)!=findPar(it.v, parent)){
                // System.out.println(it.w);
                cost+= it.w;
                union(it.u, it.v, parent, rank);
            }
        }
        return cost;
        
    }
}

