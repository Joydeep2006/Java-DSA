public class SearchInsertPositon{
    public static int searchInsert(int[] nums, int target){
        int start=0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start +(end -start)/2; // mid = (start+end)/2
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
        
    public static void main(String[] args) {
        int nums[] ={1,3,5,6};
        int key =2;
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println("Target = "+key);
        System.out.println("Insert Position "+ searchInsert(nums,key));
    }
    
}
