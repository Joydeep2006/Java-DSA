public class SubarrayWithMinSum{
    // brute force approach
    public static int findMinSum(int nums[],int l,int r){ // O(n^3)
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        // 1st loop to decide the starting idx
        for(int start=0;start<n;start++){
            // 2nd loop to decide the length
            for(int len=l;len<=r;len++){
                if(start+len > n) break;
                // to sum all the elements of the subarray
                int sum = 0;
                for(int k=start;k<start+len;k++){
                    sum += nums[k];
                }
                if(sum > 0){
                    minSum = Math.min(minSum,sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
    public static void main(String[] args) {
        int nums[] = {3, -2, 1, 4};
        int l =2;
        int r =3;
        System.out.println(findMinSum(nums, l, r));
    }   
}
