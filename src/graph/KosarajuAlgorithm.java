import java.util.*;
public class KosarajuAlgorithm {
    public static class Edge{
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    // create a test graph 
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }
    // to add vertices in toplogical order in stack
    public static void topSort(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> st){
        vis[curr] = true;
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }
    // to perform dfs
    public static void dfs(ArrayList<Edge> transpose[],int curr,boolean[] vis){
        vis[curr]=true;
        System.out.print(curr + " ");
        for(Edge e:transpose[curr]){
            if(!vis[e.dest]){
                dfs(transpose, e.dest, vis);
            }
        }
    }
    // Kosaraju's Algorithm to find the strongly connected components
    public static void kosaRaju(ArrayList<Edge>[] graph,int v){
        // Step-1
        boolean vis[] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSort(graph, i, vis, st);
            }    
        }
        // Step-2
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(Edge e: graph[i]){
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        // Step-3
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                dfs(transpose,curr,vis);
                System.out.println();
            }
        }


    }
    public static void main(String[] args) {
        int v =5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        kosaRaju(graph, v);
    }
}
