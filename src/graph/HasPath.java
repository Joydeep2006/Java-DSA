import java.util.*;
public class HasPath {
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

    // to create a graph structure
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        //vertex ->0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        //vertex ->1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //vertex ->2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //vertex ->3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        //vertex ->4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //vertex ->5
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 6, 1));

        //vertex ->6
        graph[6].add(new Edge(6, 5, 1));

    }

    // to find if there is a path between source vertex -> dest vertex
    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            // e.dest => neighbour of src
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V =7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
        }
        System.out.println(hasPath(graph, 0, 10, vis));
    }
}
