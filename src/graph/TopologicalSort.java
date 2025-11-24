import java.util.*;
public class TopologicalSort {
    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
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
    // print in topological order
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalSortUtil(graph,vis,st,i);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }

    }
    // util method of topologicalSort
    public static void topologicalSortUtil(ArrayList<Edge> graph[],boolean vis[],Stack<Integer>st,int curr){
        vis[curr] = true;
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                topologicalSortUtil(graph, vis, st, e.dest);
            }
        }
        st.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph);
    }
}
