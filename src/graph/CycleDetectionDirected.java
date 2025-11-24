import java.util.*;
public class CycleDetectionDirected {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        // vertex => 0
        graph[0].add(new Edge(0, 1));
        // vertex => 1
        graph[1].add(new Edge(1, 3));
        // vertex => 2
        graph[2].add(new Edge(2, 0));
        // vertex => 3
        graph[3].add(new Edge(3, 2));
    }
    // to detect cycle in a directed graph
    public static boolean detectCycle(ArrayList<Edge>graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean currCycle[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,currCycle,i)){
                    return true;
                }
            }
        }
        return false;
    }
    // util function to detect a cycle 
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,boolean currCycle[],int curr){
        vis[curr] = true;
        currCycle[curr] = true;
        // check all neighbbors
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                return detectCycleUtil(graph,vis,currCycle,e.dest);
            }
            else if(currCycle[e.dest]){
                return true;
            }
        }
        currCycle[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
