import java.util.ArrayList;

public class ImplementHeap {
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        // to add item in the heap
        public void add(int data){ // O(n)
            this.arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }

        // to get the min. value from the heap or peek
        public int peek(){
            return this.arr.get(0);
        }


        private void heapify(int idx){
            int left = 2*idx+1;
            int right = 2*idx+2;
            int minIdx = idx;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx = right;
            }

            if(minIdx != idx){
                int temp = arr.get(minIdx);
                arr.set(minIdx,arr.get(idx));
                arr.set(idx,temp);

                heapify(minIdx);
            }
        }
        // to remove the min element from the heap
        public int remove(){
            int data = arr.get(0);

            // step-1 swap first and last element
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            // step-2 delete the last element
            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
         
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(8);
        pq.add(2);
        pq.add(4);
        pq.add(0);

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
            
        }
    }
}
