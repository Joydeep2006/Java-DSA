package Sorting;

public class InsertionSort {
    // to display the array 
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertionSort(int arr[]){
        // for selecting the elements
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j+1]<arr[j]){
                arr[j+1] = arr[j];
                arr[j]=key;
                j--;
            }
        }

    }
    public static void main(String[] args) {
        int arr[] = {8 ,2 ,4 ,0 ,2 ,1 };
        insertionSort(arr);
        print(arr);
    }
}
