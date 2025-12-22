import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[] {map.get(need),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
        int nums[] = {2 ,7 ,11 ,15};
        int target = 9;
        int ans[] = twoSum(nums, target);
        print(ans);

    }
}
