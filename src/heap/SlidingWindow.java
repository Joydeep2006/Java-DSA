import java.util.PriorityQueue;

public class SlidingWindow {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val; // to sort in decending order
        }
    }
    public static int[] getMax(int arr[],int k){
        int res[] = new int[arr.length-k+1]; // the output array size
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        // 1st window
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }
        // 1st window's maximum
        res[0] = pq.peek().val;
        
        for(int i=k;i<arr.length;i++){
            while(pq.isEmpty() && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i],i));
            res[i-k+1] = pq.peek().val;
        }
        return res;

    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[] = getMax(arr,k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

        
    }
}
