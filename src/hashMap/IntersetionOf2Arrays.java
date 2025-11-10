import java.util.*;

public class IntersetionOf2Arrays {
    // LeetCode problem 349
    public static int[] intersection(int nums1[],int nums2[]){
        ArrayList<Integer>result = new ArrayList<>();
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        // declare the resultant array
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int res[] = new int[result.size()];
        // copy from the arrayList
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}
