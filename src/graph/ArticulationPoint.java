import java.util.ArrayList;

public class ArticulationPoint {
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
    // Tarjan's algorithm to find articulation point in graph
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],int low[],int time,boolean vis[],boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(Edge e : graph[curr]){
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }
            else if(vis[neigh]){
                low[curr]= Math.min(low[curr],dt[neigh]);
            }
            else{
                dfs(graph, neigh, curr, dt, low, time, vis,ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(par != - 1 && dt[curr] <= low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 & children > 1){
           ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph,int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, time, vis,ap);
            }
        }
        // to print all articulation points
         for(int i=0;i<graph.length;i++){
            if(ap[i]){
                System.out.println("AP : " + i);
            }
        }
    }
    public static void main(String[] args) {
        int v =5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);
       
    }
}
