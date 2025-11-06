import java.util.PriorityQueue;
public class NRopes {
    public static int minCost(int arr[]){
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // add all the ropes in the priority queue
        for(int i=0;i<arr.length;i++){
            pq.add(i);
        }

        while(pq.size() > 1){
            int rope1 = pq.poll();
            int rope2 = pq.poll();
            cost+=rope1+rope2;
            pq.add(rope1+rope2);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] arr={2,3,3,4,6};
        System.out.print("Minimum cost of adding N ropes "+minCost(arr));
    }
}
