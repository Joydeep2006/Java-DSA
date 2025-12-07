public class PartionEvenSum{
    // difference does not depend on i it depends only on total
    public static int countPartitions(int nums[]){
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        return (total % 2 == 0) ? (nums.length-1) : 0;
    }
    /*
        leftSum + rightSum = total
        so,
            leftSum - rightSum
        =>  leftSum + leftSum - total
        => 2*leftSum - total   // => and leftSum is always even 
    */
    public static void main(String[] args) {
        int nums[] = {10,10,3,7,6};
        System.out.println(countPartitions(nums));
    }
}
