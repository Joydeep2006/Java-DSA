public class RotatedArraySearch {
    public static int search(int arr[],int key){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+end/2-start/2; // mid = start+end/2
            if(arr[mid]==key){
                return mid;
            }
            if(arr[start]<=arr[mid]){
                if(arr[start]<= key && arr[mid] >= key){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }

            }
            else{
                if(arr[mid]<= key && key<= arr[end]){
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr[] = {7,8,9,1,2,3,4,5,6};
        System.out.println("Element Found at Index : "+search(arr, 1));
    }
    
}
