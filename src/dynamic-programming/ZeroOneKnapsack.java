public class ZeroOneKnapsack {
    // using recursion 
    public static int knapsack(int dp[][],int wt[],int val[],int n,int W){
        if(W == 0 || n == val.length){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n] <= W){
            // include it in knapsack
            int ans1 = val[n] + knapsack(dp,wt, val, n+1, W-wt[n]);
            // exclude it 
            int ans2 = knapsack(dp,wt, val, n+1, W);
            return dp[n][W]= Math.max(ans1,ans2);   
        }
        else{
            return dp[n][W] = knapsack(dp,wt,val,n+1,W);
        }
    }
    // using tabulation 
    public static int knapsackTab(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        // initialize
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0; 
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1] <=j){// valid condition
                    int w = wt[i-1];
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-w],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15 , 14 , 10 , 45 , 30};
        int wt[] = {2 ,5 ,1 ,3 ,4};
        int W = 7;
        int dp[][] = new int[val.length][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(dp,wt, val, 0, W));
        System.out.println(knapsackTab(val, wt, W));
    }
}
