import java.util.HashMap;
import java.util.Set;
public class MajorityElement {
    public static void majority(int arr[]){
        // storing elements and their count as key value pairs in HashMap
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else{
                hm.put(arr[i],1);
            }
            // we can skip the if-else part by the below
            //hm.put(arr[i],hm.getOrDefault(hm,0)+1);
        }
        Set<Integer>keys = hm.keySet();
        for(Integer i :keys){
            if(hm.get(i)>(arr.length/3)){
                System.out.print(i+" ");
            }
        }
    } 
    public static void main(String[] args) {
        int arr[] = {1 ,3 ,2 ,5 ,1 ,3 ,1 ,5 ,1};
        majority(arr);
    }
}
