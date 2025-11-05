package Heap;
public class HeapSort{
    public static void heapify(int arr[],int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }

        if(right < size && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx!=i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr,maxIdx,size);
        }

    }
    public static void heapSort(int arr[]){
        // step -1 build Max Heap
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        // push largest at the end
        for(int i=n-1;i>0;i--){
            // swap the largest 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i);
        }

    }
    public static void main(String[] args) {
        int arr[] = {8,2,4,0,2,1};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}