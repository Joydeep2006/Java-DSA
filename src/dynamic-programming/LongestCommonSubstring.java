public class LongestCommonSubstring {
    // using tabulation
    public static int findlongest(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        // initialise 
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        int maxlen = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxlen = Math.max(maxlen,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abfce";
        System.out.println(findlongest(str1, str2));
    }
}
