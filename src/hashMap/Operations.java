import java.util.HashMap;
import java.util.Set;

public class Operations {

    public static void interate(HashMap<String,Integer>hm){
        Set<String>keys = hm.keySet(); // the set contains all the keys of the hashMap
        // iterate over the keys
        for(String k : keys){
            System.out.println("Key = "+k+",Value = "+hm.get(k));
        }

    }
    public static void main(String[] args) {
        HashMap<String,Integer>hm = new HashMap<>();
        // putting key value pair in HashMap
        hm.put("Suman",48);
        hm.put("Sudip",47);
        hm.put("Soumik",187);
        hm.put("Joydeep",104);

        System.out.println(hm.get("Joydeep")); // returns the value of the key
        System.out.println(hm.containsValue(47)); // returns true if the value is present
        System.out.println(hm.containsKey("Jagat"));
        System.out.println(hm.get("Jagat")); // returns null if key not present

        // to clear the HashMap
        hm.clear();

        // again putiing the data
        hm.put("Suman",48);
        hm.put("Sudip",47);
        hm.put("Soumik",187);
        hm.put("Joydeep",104);
        interate(hm);
    }
}
