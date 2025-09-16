import java.util.Arrays;

class MinAbsDifference{
    public static int minDiff(int a[],int b[]){
        // sort the arrays so that we can take the diff of the smaller 
        // numbers of both of the arrays 
        Arrays.sort(a);
        Arrays.sort(b);
        int diff =0;
        for(int i=0;i<a.length;i++){
            diff += Math.abs(a[i]-b[i]);
        }
        return diff;

    }
    public static void main(String[] args) {
        int arr1[] ={1, 2, 3};
        int arr2[] ={2, 2, 3};
        System.out.println("Minimum absolute difference is : "+minDiff(arr1,arr2));
        
    }
}
