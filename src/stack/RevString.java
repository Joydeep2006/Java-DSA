import java.util.*;
public class RevString {
    public static StringBuilder revStr(String str){
        Stack<Character>s1 = new Stack<>();
        for(int i=0;i<str.length();i++){
            s1.push(str.charAt(i));
        }
        StringBuilder rev = new StringBuilder("");
        while(!s1.isEmpty()){
            rev.append(s1.pop());
        }
        return rev;
    }
    public static void main(String[] args){
        String name = "Joydeep";
        System.out.println(name);
        System.out.println(revStr(name));
        
    }
    
}
