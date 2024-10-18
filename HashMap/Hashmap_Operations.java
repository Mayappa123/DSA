import java.util.*;
public class Hashmap_Operations {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String,Integer>();
             map.put("India", 151);
             map.put("China", 120);
             map.put("US", 109);
             map.put("Japan", 97);

             System.out.println(map);

             // Get
             int population = map.get("India");
             System.out.println(population);

             System.out.println(map.get("Indonasia"));   // Returns null if key doesnt exists.

             // containsKey
             System.out.println(map.containsKey("India"));     //true
             System.out.println(map.containsKey("Nepal"));     // false

             // remove
             System.out.println(map.remove("India"));
             System.out.println(map);

             // size
             System.out.println(map.size());

             //IsEmpty
             System.out.println(map.isEmpty());

             // clear
             map.clear();

    }
}