public class Permutations {
    public static void findPermutations(String str,String ans){ // T.C => O(n*n!)
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            // "Joydeep" =>"Joy" + "eep"
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutations(newStr, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str = "joy";
        findPermutations(str, "");
        
    }
}
