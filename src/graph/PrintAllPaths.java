import java.util.*;
public class PrintAllPaths {
    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src =src;
            this.dest = dest;
        }
    }
    // to print all the paths from source to destination
    public static void printPaths(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src==dest){
            System.out.println(path+" "+dest);
            return;
        }
        // check for all the neighbors
        for(Edge e : graph[src]){
            printPaths(graph, e.dest, dest, path+" "+src);
        }
        
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        // vertex => 2
        graph[2].add(new Edge(2, 3));
        // vertex => 3
        graph[3].add(new Edge(3, 1));
        // vertex => 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        // vertex => 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));   
    }
    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        int src = 5;
        int dest = 1;
        printPaths(graph, src, dest, "");
    }
}
