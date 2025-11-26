import java.util.*;
public class BellmanFord{
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

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //vertex - 0
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0, 2, 4));
        //vertex - 1
        graph[1].add(new Edge(1, 2, -4));
        //vertex - 2
        graph[2].add(new Edge(2, 3, 2));
        //vertex - 3
        graph[3].add(new Edge(3,4,4));
        //vertex - 4
        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];
        // initialise with infinity
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // O(V*E)
        // run the loop for total vertex -1 times
        for(int i=0;i<graph.length-1;i++){
            // edges - O(E)
            for(int j=0;j<graph.length;j++){
                for(Edge e: graph[j]){
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] =  dist[u] + wt;
                    }
                }
            }
        }
        // print all the shortest dist
        for(int i=0;i<dist.length;i++){
            System.out.println(src+" -> "+" = "+dist[i]);
        }
        

    }
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        bellmanFord(graph, src);        
    }
}
