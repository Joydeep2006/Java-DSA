import java.util.*;
public class KrushkalsMST {
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    // to initialise the parent array
    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }
    // to find the parent of a set
    public static int find(int x){
        if(x == par[x]){
            return x; 
        }
        return par[x] = find(par[x]);
    }
    // to union of two sets
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB] = parA;
        }
        else{
            par[parA] = parB;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    // create a graph structure
    public static void createGraph(ArrayList<Edge>edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }
    // Krushkal's algorithm to calculate the cost of MST
    public static int krushkal(ArrayList<Edge> edges,int V){
        Collections.sort(edges);
        int mstCost = 0;
        for(Edge e:edges){
            int parA = find(e.src);
            int parB = find(e.dest);
            // parent is not same
            if(parA != parB){
                union(e.src,e.dest);
                mstCost+=e.wt;
            }
        }
        return mstCost;
    }

    public static void main(String[] args){
        int V =4;
        init();
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        System.out.println(krushkal(edges, V));


    }
}
