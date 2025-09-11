import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class ActivitySelection {

    // this function will work properly if activities are sorted according to their ending time
    public static int maxActSort(int start[],int end[]){
        // we will perform at least one activity so max is initialised as 1
        int max = 1;
        // we will select the first activity as it will finish at first 
        int lastEnd = end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastEnd){
                max++;
                lastEnd = end[i];
            }
        }
        return max;
    }

    // function which can handle the unsorted activities also 
    public static void maxAct(int start[],int end[]){
        // we need a 2-D array to store all the activities then sort them
        int activites[][] = new int[start.length][3];
        // arraylist to store the the activites
        ArrayList<Integer>list = new ArrayList<>();
        list.add(0);

        // filling the activities in the 2-D array
        for(int i=0;i<start.length;i++){
            activites[i][0]= i;
            activites[i][1]= start[i];
            activites[i][2]= end[i];
        }
        // to sort the 2-D array we used lamda function 
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
        int max =1;
        int lastEnd = activites[0][2];
        for(int i=1;i<activites.length;i++){
            if(activites[i][1]>=lastEnd){
                max++;
                lastEnd = activites[i][2];
                list.add(i);
            }
        }
        System.out.println("Maximum activites one can perform : "+max);
        System.out.println(list);

    }
    public static void main(String[] args){
        // starting time of each activites
        int start[] = {3, 1, 0, 5, 8, 5};
        // ending time of corresponding activites in sorted order
        int end[] ={4, 2, 6, 7, 9, 9};
 
        //System.out.println("Maximum activites one can perform : "+maxAct(start,end));
        maxAct(start,end);

        
    }
    
}
