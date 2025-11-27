import java.util.*;
public class PrimMST {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    // to store vertex and it's weight
    public static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        public Pair(int vtx,int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }  
    // to create a test graph
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //vertex - 0
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        //vertex - 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        //vertex - 2
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        //vertex - 3
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
    // Prim's algorithm to find the minCost to connect all vertices
    public static void primMST(ArrayList<Edge> graph[]){
        Queue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[graph.length];
        pq.add(new Pair(0,0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.vtx]){
                vis[curr.vtx] = true;
                finalCost += curr.wt;
                for(Edge e : graph[curr.vtx]){
                    pq.add(new Pair(e.dest,e.wt));
                }
            }

        }
        System.out.print("MinCost => "+ finalCost);
    }
    public static void main(String[] args) {
        int v =4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        primMST(graph);
    }
}
