import java.util.*;
import java.util.LinkedList;
public class BipartiteGraph {
    static class Edge{
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    // check if graph is bipartite or not 
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int colors[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        // initialise colors with - 1 => here colors array will be like visit array
        for(int i=0;i<colors.length;i++){
            colors[i] = -1;
        }
        for(int i=0;i<graph.length;i++){
            if(colors[i] == -1){
                q.add(i);
                colors[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        // check neighbor
                        if(colors[e.dest] == -1){ // case - 1(no color)
                            int nextCol = colors[curr] == 0 ? 1 : 0;
                            colors[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(colors[e.dest] == colors[curr]){ // case - 2(same color)
                            return false;
                        }
                        // for opposite color do nothing -> check amother neighbor
                    }
                }

            }  
            
        }
        return true;
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        // create a sample graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }


}
