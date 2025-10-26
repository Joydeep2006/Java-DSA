package sorting;
public class BubbleSort {
    // bubbleSort function 
    public static void bubbleSort(int arr[]){ // => O(n^2)
        // outer loop
        for(int i=0;i<arr.length-1;i++){
            // inner loop
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;                
                }
            }
        }
    }
    // modified BubbleSort 
    public static void modifiedBubbleSort(int arr[]){ // => O(n^2)
        // outer loop
        for(int i=0;i<arr.length-1;i++){
            // inner loop
            int flag = 0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = 1;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;                
                }
            }
            if(flag == 0){
                break;
            }
        }
    }
    // to display the array 
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {8 ,2 ,4 ,0 ,2 ,1 };
        //bubbleSort(arr);
        modifiedBubbleSort(arr);
        print(arr);
    }
}
