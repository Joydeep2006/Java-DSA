import java.util.*;
public class IndianCoins{
    public static void countCurr(int amount){
        int count=0;
        Integer coins[]={1 ,2 ,5 ,10 ,20 ,50 ,100 ,200 ,500 ,2000 };
        // reversing the coins array
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(amount >= coins[i]){
                while(amount >=coins[i]){
                    amount-= coins[i];
                    ans.add(coins[i]);
                    count++;
                }
            }
        }

        System.out.println("Min No. of notes "+count);
        System.out.println("Coins : " + ans);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Amount : ");
        int amount = sc.nextInt();
        countCurr(amount);
        sc.close();

        
    }
}
