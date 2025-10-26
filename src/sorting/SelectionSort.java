package Sorting;

public class SelectionSort {
    // to display the array 
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // selectionSort function
    public static void selectionSort(int arr[]){
        // outer loop for selecting the position to swap
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            // selecting the position of the min. element
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;  
        }
    }

    public static void main(String[] args) {
        int arr[] = {8 ,2 ,4 ,0 ,2 ,1 };
        selectionSort(arr);
        print(arr);
    }
}
