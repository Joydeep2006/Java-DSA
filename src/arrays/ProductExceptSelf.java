public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        // product of the elements on the left side of it
        for(int i=1;i<nums.length;i++){
            answer[i] = answer[i-1] * nums[i-1];
        }
        // product of the elements on the right side of it * left side
        int suffix = 1;
        for(int i=n-1;i>=0;i--){
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }
        return answer;
    }
    // to print the answer array 
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] answer = productExceptSelf(nums);
        print(answer);
    }   
}
