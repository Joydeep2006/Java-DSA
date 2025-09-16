import java.util.Arrays;
import java.util.Comparator;
public class ChainOfPairs {
    public static int maxlen(int pairs[][]){
        int maxlen = 1;
        int chainEnd = pairs[0][1];
        Arrays.sort(pairs,Comparator.comparingDouble ( o -> o[1])); 
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]> chainEnd){
                maxlen++;
                chainEnd = pairs[i][1];
            }
        }
        return maxlen;

    }
    public static void main(String[] args) {
        int pairs[][] = {{5,24} , {39,60} , {5,28} , {27,40} ,{50,90}};
        System.out.println("Maximum length of chain of pairs "+ maxlen(pairs));

        
    }
    
}
