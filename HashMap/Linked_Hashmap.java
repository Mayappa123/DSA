import java.util.*;;
public class Linked_Hashmap { 
    public static void main(String[] args) {
        LinkedHashMap< String, Integer> map = new LinkedHashMap<String,Integer>();

             map.put("India", 151);
             map.put("China", 120);
             map.put("US", 109);
             map.put("Japan", 97);

             System.out.println(map);

            HashMap< String, Integer> hashmap = new HashMap<String,Integer>();
             hashmap.put("India", 151);
             hashmap.put("China", 120);
             hashmap.put("US", 109);
             hashmap.put("Japan", 97);

             System.out.println(hashmap);

             TreeMap< String, Integer> treemap = new TreeMap<String,Integer>();
             treemap.put("India", 151);
             treemap.put("China", 120);
             treemap.put("US", 109);
             treemap.put("Japan", 97);

             System.out.println(treemap);



    }
    
}
