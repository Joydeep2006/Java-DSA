import java.util.Arrays;
import java.util.HashSet;

public class LongestIncSubsequence {
    // longest common subsequence
    public static int lcs(int arr1[],int arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        int dp[][] = new int[m+1][n+1];
        // initialize
        for(int i=0;i<m+1;i++){
            dp[i][0] = 0;
        }
        for(int i =0;i>n+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];

    }
    // to find the longest increasing subsequence
    public static int lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        // sorted array
        int i=0;
        for (Integer num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr,arr2);
    }

    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(lis(arr));
    }
}
