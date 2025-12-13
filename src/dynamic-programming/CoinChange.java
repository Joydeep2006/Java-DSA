public class CoinChange {
    public static int ways(int coins[],int total){
        int n = coins.length;
        int dp[][] = new int [n+1][total+1];
        //initialise
        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<total+1;j++){
                if(coins[i -1] <= j){
                    int val = coins[i-1];
                    dp[i][j] = dp[i][j-val] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                 
            }
        }
        return dp[n][total];
    }
    public static void main(String[] args) {
        int coins[] = {1 ,2 ,3};
        int total = 4;
        System.out.println(ways(coins,total));
    }
}
