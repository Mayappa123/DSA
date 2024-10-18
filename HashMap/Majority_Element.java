import java.util.*;
public class Majority_Element { 
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1, 3, 2};
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i<arr.length; i++) {
            // if(map.containsKey(arr[i])) {
            //     map.put(arr[i], map.get(arr[i])+1);
            // } 
            // else {
            //     map.put(arr[i], 1);
            // }
        
            // OR

            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        // Set<Integer> keySet = map.keySet();
        for(Integer Key : map.keySet()) {
            if(map.get(Key) > arr.length/3) {
                System.out.println(Key);
            }
        }
        
    }
    
}
