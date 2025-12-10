public class ZeroOneKnapsack {
    // using recursion 
    public static int knapsack(int wt[],int val[],int n,int W){
        if(W == 0 || n == val.length){
            return 0;
        }
        if(wt[n] <= W){
            // include it in knapsack
            int ans1 = val[n] + knapsack(wt, val, n+1, W-wt[n]);
            // exclude it 
            int ans2 = knapsack(wt, val, n+1, W);
            return Math.max(ans1,ans2);
        }
        else{
            return knapsack(wt,val,n+1,W);
        }
    }
    public static void main(String[] args) {
        int val[] = {15 , 14 , 10 , 45 , 30};
        int wt[] = {2 ,5 ,1 ,3 ,4};
        int W = 7;
        System.out.println(knapsack(wt, val, 0, W));
    }
}
