public class LongestCommonSubsequence {
    // using recursion & memoization
    public static int lcs(String str1,String str2,int m,int n,int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[m-1][n-1] != -1){
            return dp[m][n];
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return dp[m][n] = 1 + lcs(str1, str2, m-1, n-1,dp);
        }
        return dp[m][n] = Math.max(lcs(str1, str2, m-1, n, dp), lcs(str1, str2, m, n-1,dp));
    }
    // using tabulation
    public static int lcsTab(String str1,String str2){
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        // initialise
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if( i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }       
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int dp[][] = new int [str1.length()][str2.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs(str1, str2, str1.length(), str2.length(),dp));
        System.out.println(lcsTab(str1, str2));
    }
}
