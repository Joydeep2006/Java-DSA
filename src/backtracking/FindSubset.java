public class FindSubset {
    public static void getSubsets(String str,int i,String ans){
        // base case 
        if(i == str.length()){
            System.out.println(ans+" ");
            return;
        }
        // Yes - choice
        getSubsets(str, i+1, ans+str.charAt(i));
        // No - choice
        getSubsets(str, i+1, ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        getSubsets(str, 0, ans);
        
    }
}
