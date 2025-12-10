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
    }
}
