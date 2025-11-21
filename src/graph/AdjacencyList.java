import java.util.ArrayList;

public class AdjacencyList{
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
/*              (5)
            0 ----- 1
                   / \
               (1)/   \ (3)
                 /     \
                2 ------3 
                |  (1)
             (2)|
                |
                4
 */


    public static void printNeighbors(ArrayList<Edge>[] graph,int vertex){
        for(int i=0;i<graph[vertex].size();i++){
            Edge e = graph[vertex].get(i);
            System.out.print(e.dest+" ");
        }
    }
    public static void main(String[] args) {
        // no. of vertices of a graph
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];

        // initialise the array with empty arrayList
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // vertex - 0
        graph[0].add(new Edge(0,1,5));

        // vertex - 1
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 0, 5));

        // vertex - 2
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // vertex - 4
        graph[4].add(new Edge(4, 2, 2));

        printNeighbors(graph, 1);




    }
}
