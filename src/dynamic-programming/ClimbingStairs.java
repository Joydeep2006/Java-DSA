public class ClimbingStairs{
    // using recursion & dp (memoization)
    public static int ways(int dp[],int n){ // O (n)
        if(n == 1 || n == 2){
            return dp[n] = n;
        }
        if(dp[n] == 0){
            dp[n] = ways(dp,n-1) + ways(dp,n-2);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1];
        System.out.println(ways(dp,n));
    }
}
