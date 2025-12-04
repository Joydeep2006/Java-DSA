import java.util.*;
public class BridgeInGraph {
    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    // to create a test graph
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }
    // tarjan's algorithm to detect bridge in graph
    public static void dfs(ArrayList<Edge>[] graph,int curr,int par,int dt[],int low[],boolean vis[],int time){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for(Edge e:graph[curr]){
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }
            else if(!vis[neigh]){
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr] < low[neigh]){
                    System.out.println("Bridge : " + curr + "----" + neigh);
                }
            }
            else{
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public static void tarjanBridge(ArrayList<Edge>[] graph,int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time);
            }
        }
    }
    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        tarjanBridge(graph, v);
        
    }
}
