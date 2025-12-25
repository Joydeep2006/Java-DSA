public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int count=0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }
        } 
        // traverse from the end
        for(int i=n-1;i>=0;i--){
            if(i + count < n){
                arr[i+count]=arr[i];
            }
            // If zero - duplicate it 
            if(arr[i] == 0){
                count--;
                if(i + count < n){
                    arr[i+count] = 0;
                }
            }
        }   
    }
    // to print the array 
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1 ,0 ,2 ,3 ,0 ,4 ,5 ,0 };
        duplicateZeros(arr);
        print(arr);
    }
}
