public class TargetSum {
    public static boolean targetSum(int arr[],int target){
        boolean dp[][] = new boolean[arr.length+1][target+1];
        // initialise
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int val = arr[i-1];
                // include
                if(val <= j  && dp[i-1][j-val]){
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[arr.length][target];
    }
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.printf("%8b",dp[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[] = {4 ,2 ,7 ,3 ,1 };
        int target = 10;
        System.out.println(targetSum(arr,target));
    }
}
