public class WildCardMatch {
    
    public static boolean match(String str,String pattern){
        int m = str.length();
        int n = pattern.length();
        boolean dp[][] = new boolean[m+1][n+1];
        // initialise
        dp[0][0] = true;
        for(int j = 1;j<n+1;j++){
            if(pattern.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<m+1;i++){
            dp[i][0] = false;
        }
        // tabulation
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                     dp[i][j] = false;
                }
               
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String str ="abcd";
        String pattern = "**c?*";
        System.out.println(match(str, pattern));
    }
}
