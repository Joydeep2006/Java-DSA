public class MountainValleys {
    public static int mountainInRange(int n){
        int dp[] = new int[n+1];
        // initialise
        dp[0] = dp[1] = 1;
        // tabulation
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainInRange(n));
    }
}
