import java.util.*;
public class NextGreaterElement{
    public static void main(String[] args) {
        Stack<Integer> st =new Stack<>();
        int[] arr = {6,8,0,1,3};
        int[] newArr = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                newArr[i]=-1;
            }
            else{
                newArr[i]=arr[st.peek()];
            }
            st.push(i);
        }
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]);
        // }
        for(int i=0;i<newArr.length;i++){
            System.out.print(newArr[i]+" ");
        }
    }
}