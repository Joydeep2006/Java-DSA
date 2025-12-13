public class RodCutting {
    public static int maxValue(int rodPieces[],int val[],int totalLength){
        int n = rodPieces.length;
        int dp[][] = new int[rodPieces.length+1][totalLength+1];
        // initialise
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<totalLength+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totalLength+1;j++){
                int len = rodPieces[i-1];
                if(len <= j){
                     dp[i][j] = Math.max(val[i-1]+dp[i][j-len],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totalLength];
    }
    public static void main(String[] args) {
        int rodPieces[] = {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8};
        int val[] = {1 ,5 ,8 ,9 ,10 ,17 ,17 ,20};
        int rodLength = 8;
        System.out.println(maxValue(rodPieces, val, rodLength));
    }
}
