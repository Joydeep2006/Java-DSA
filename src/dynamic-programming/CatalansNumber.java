public class CatalansNumber {
    // to calculate catalan's number using memoization
    public static int cat(int num,int dp[]){
        if(num == 0 || num == 1){
            return dp[num];
        }
        if(dp[num] != 0){
            return dp[num];
        }
        // calculate
        int sum = 0;
        for(int i=0;i<num;i++){
            sum += cat(i,dp) * cat(num-1-i,dp);
        }
        return dp[num] = sum;
        
    }
    // calculate catalan's number using tabulation
    public static int catTab(int num){
        int dp[] = new int[num+1];
        // initialise
        dp[0] = dp[1] = 1;
        for(int i=2;i<=num;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-1-j];
            }

        }
        return dp[num];
    } 
    public static void main(String[] args) {
        int num = 3;
        int arr[] = new int[num+1];
        arr[0] = 1;
        arr[1] = 1;
        System.out.println(cat(num, arr));
        System.out.println(cat(num, arr));

    }
}
