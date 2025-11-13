import java.util.HashMap;
public class SubarraySumEqualToK {
    public static int countSubarrays(int arr[],int k){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int sum = 0;
        int ans = 0;
        hm.put(0,1);
        // if-sum doesn't exist in the map then add it
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        return ans; 

    }
    public static void main(String[] args) {
        int arr[] = {10 ,2 ,-2 ,-20 ,10 };
        int k = -10;
        System.out.println("Total no. of Sub-arrays : "+countSubarrays(arr, k));

    }
}
