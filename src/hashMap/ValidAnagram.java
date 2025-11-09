import java.util.HashMap;

public class ValidAnagram {
    // to check if the strings are anagram or not
    public static boolean isValid(String str1,String str2){
        HashMap<Character,Integer>hm = new HashMap<>();
        // to store the characters and their freq in the string
        for(int i=0;i<str1.length();i++){
            char key = str1.charAt(i);
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        // traverse the second string 
        for(int i=0;i<str2.length();i++){
            char key = str2.charAt(i);
            if(hm.containsKey(key)){
                if(hm.get(key) == 1){
                    hm.remove(key);
                }else{
                    hm.put(key,hm.get(key)-1);
                } 
            }
            else{
                return false;
            }    
        }
        return hm.isEmpty();
    }
    public static void main(String[] args) {
        String str1 = "keen";
        String str2 = "knee";
        System.out.println(isValid(str1, str2));
    }
}
