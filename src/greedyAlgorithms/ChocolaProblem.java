import java.util.*;

public class ChocolaProblem {

    public static void  calCost(int col,int row,Integer costVer[],Integer costHor[]){
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        // sorting based on cuts => so that expensive cuts are performed first on less no. of pieces
        int h =0 ,v=0; // => two pointers for two arrays
        int hp = 1, vp = 1;
        int cost =0;

        while(h<costHor.length && v<costVer.length){
            // horizontal cut
            if(costVer[v] <= costHor[h]){
                cost += costHor[h]*vp;
                hp++;
                h++;
            }
            // vertical cut 
            else{
                cost += costVer[v] * hp;
                vp++;
                v++;
            }

        }

        // left over horizontal cuts
        while(h < costHor.length){
            cost += costHor[h]*vp;
                hp++;
                h++;
        }

        // left over vertical cuts
        while(v< costVer.length){
            cost += costVer[v] * hp;
                vp++;
                v++;
        }

        System.out.println("Minimum cost : "+ cost);
    }

    public static void main(String[] args) {
        int col = 4 , row = 6;
        Integer costVer[] = {2 ,1 ,3 ,1 ,4};
        Integer costHor[] = {4 ,1 ,2};
        calCost(col, row, costVer, costHor);
        
    }
    
}
