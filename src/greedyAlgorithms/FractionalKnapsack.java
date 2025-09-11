package GreedyAlgorithms;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static int maxProfit(int weight[],int value[],int cap){
        // ratio of the given items determine which one is more profitable
        double ratio[][] = new double[weight.length][2];
        // 2nd coloumn of the list stores the ratios of the items
        for(int i=0;i<ratio.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        // sort in ascending order
        Arrays.sort(ratio,Comparator.comparingDouble( o -> o[1]));
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(cap>=weight[idx]){ // include full item
                finalVal+= value[idx];
                cap = cap-weight[idx];
            }
            else{// inlclude the item in how much capacity left
                finalVal+=(cap * ratio[i][1]);
                cap = 0;
                break;
            }
        }
        return finalVal;
    }

    public static void main(String[] args){
        // item weights 
        int value[] = {60, 100, 120};
        // value corresponding to their weight
        int weight[] = {10, 20, 30};
        int cap = 50;
        System.out.println("Maximum profit will be : "+maxProfit(weight, value,cap));
        
    }
    
}
