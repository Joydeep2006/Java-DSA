import java.util.Arrays;
import java.util.HashSet;
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // sort the array 
        Arrays.sort(nums);
        // check for duplicates
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    // using hashSet
    public static boolean containsDuplicateHashing(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateHashing(nums));
    }
}
