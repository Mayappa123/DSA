import java.util.*;
public class Iterations_on_hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
             map.put("India", 151);
             map.put("China", 120);
             map.put("US", 109);
             map.put("Japan", 97);
             map.put("Bhutan", 120);
             map.put("ShriLanka", 100);

             //Oterate
             Set<String> keys = map.keySet();
             System.out.println(keys);

             for (String k : keys) {
                System.out.println("Key = " +k+", "+"value = "+map.get(k));
                
             }

    }
    
}
