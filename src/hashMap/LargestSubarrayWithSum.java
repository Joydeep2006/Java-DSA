import java.util.HashMap;

public class LargestSubarrayWithSum {
    // to calculate the size of the largest sub array with sum 0 
    public static int largestSubarray(int arr[]){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int sum = 0;
        int largest = -1;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum)){
                largest = Math.max(largest,i - hm.get(sum));
            }
            else{
                hm.put(sum,i);
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr[] = {15 ,-2 ,2 ,-8 ,1 ,7 ,10};
        System.out.println(largestSubarray(arr));
    }
}
