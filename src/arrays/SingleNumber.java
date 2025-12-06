public class SingleNumber {
    // xor-ing all element leaves us with only the single time appearing number
    public static int findSingle(int nums[]){
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};
        System.out.println(findSingle(nums));
    }
}
