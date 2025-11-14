import java.util.*;

public class RomanToInteger {
    public static int romanToInt(String s){
        HashMap<Character,Integer>map = new HashMap<>();
        // putting all the letters and their values in the hashMap
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;

        for(int i=0;i<s.length();i++){
            int curr = map.get(s.charAt(i));
            if(i+1<s.length()){
                int next = map.get(s.charAt(i+1));
                if(curr<next){
                    ans -= curr;
                    continue;
                }
            }
            ans += curr;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        
    }
}
