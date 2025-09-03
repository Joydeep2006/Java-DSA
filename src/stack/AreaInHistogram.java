import java.util.*;
public class AreaInHistogram {
    public static int maxArea(int arr[]){
        int maxArea = 0;
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];
        Stack<Integer>st = new Stack<>();

        // Finding next smaller right => O(n)
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=nsr.length;
            }
            else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();

        // Finding next Smaller left => O(n)
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]= -1;
            }
            else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }

        // calculate rectangular area
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height*width;
            maxArea = Math.max(currArea,maxArea);
        }
        
        return maxArea;
    }
    public static void main(String[] args){
        int arr[] = {2,4};
        System.out.print("Maximum Rectangular Area in Histogram is : "+maxArea(arr));
        
    }
    
}
