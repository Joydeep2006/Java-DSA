public class EditDistance {
    public static int countOperations(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        // initialize
        for(int i=0;i<m+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){ // same
                    dp[i][j] = dp[i-1][j-1];
                }
                else{ // diff
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String str1 = "insertion";
        String str2  = "execution";
        System.out.println(countOperations(str1, str2));
    }
}    
