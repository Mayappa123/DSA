import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashmap {
    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<>();


        // Insertion using put() function....
        map.put("India", 120);
        map.put("US", 150);
        map.put("China", 110);
        System.out.println(map);


        // To change the value of existing key....
        map.put("India", 135);
        System.out.println(map);


        // Searching....
        if(map.containsKey("US")) {
            System.out.println("US not contains in map"); 
        }
        

        // To retrieve any key using get() function....
        System.out.println(map.get("India"));
        

        // Regular for loop....
        int arr[] = {12, 15, 18};
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        

        // Collection for loop....
        for(int val:arr) {
            System.out.print(val+" ");
        }
        System.out.println();


        // For loop in HashMap....
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.print(e.getKey()+" ");
            System.out.print(e.getValue());
            System.out.println();
        }
        System.out.println();
        //OR
        Set<String> keys = map.keySet();
        for(String key:keys) {
            System.out.println(key+" "+map.get(key));
        }
        System.out.println();


        // Remove any key along with its value using remove() function....
        map.remove("China");
        System.out.println(map);
        
        





    }
}
