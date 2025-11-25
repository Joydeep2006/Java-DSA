import java.util.*;
public class DijkstraAlgo {
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
    // to create a graph to test on 
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //vertex - 0
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0, 2, 4));
        //vertex - 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1,3,7));
        //vertex - 2
        graph[2].add(new Edge(2, 4, 3));
        //vertex - 3
        graph[3].add(new Edge(3,5,1));
        //vertex - 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        //vertex - 5
    }
    // to store the vertex and its correspoding shortest distance from src
    static class Pair implements Comparable<Pair>{
        int n;
        int dis;
        public Pair(int n,int dis){
            this.n = n;
            this.dis = dis;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dis - p2.dis;
        }
    }
    // to calculate the shortest path for all vertex from src
    public static void dijkstra(ArrayList<Edge>[] graph,int src){
        int dist[] = new int[graph.length];
        // initialise all the vertex except src to distance infinity
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // priority queue to store all the pairs and get the pair with the shortest dist
        Queue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,dist[src]));
        boolean vis[] = new boolean[graph.length];
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                // check for all the neighbors
                for(Edge e : graph[curr.n]){
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // check for the shortest distance
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        // print all the shortest distance
        for(int i=0;i<dist.length;i++){
            System.out.println(src+" -> "+i+" = "+dist[i]);
        }
    }

    public static void main(String[] args) {
        int v =6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);

    }
}
