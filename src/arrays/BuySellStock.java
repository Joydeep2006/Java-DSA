public class BuySellStock{
    public static int maxProfit(int prices[]){
        int minPrice = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            int profit = prices[i] - minPrice;
            minPrice = Math.min(minPrice,prices[i]);
            max = Math.max(max, profit);
        }
        return max;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));    
    }
}
