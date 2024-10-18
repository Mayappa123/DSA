package Map;

import java.util.*;

public class hashmap {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "India");
        map.put(2, "US");
        map.put(3, "China");
        map.put(4, "UK");
        System.out.println(map);

        int a = map.size();
        System.out.println(a);

        map.put(5, "India");
        System.out.println(map);

        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(6)) {
                System.out.println(map.get(6));

            } else {
                System.out.println("Key not found");
                break;
            }
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.containsValue("US")) {
                System.out.println(map.get(2));
                break;
            } else {
                System.out.println("Value not found");

            }
        }

    }
}
