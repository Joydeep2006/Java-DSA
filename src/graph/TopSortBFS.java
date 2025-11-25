import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopSortBFS {
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

    public static void calInDeg(ArrayList<Edge> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            for(Edge e : graph[i]){
                indeg[e.dest]++;
            }
        }
    }
    // to pritn topological sort using BFS Kahn's Algorithm
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calInDeg(graph, indeg);
        
        for(int i=0;i<graph.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(Edge e : graph[curr]){
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
    
}
