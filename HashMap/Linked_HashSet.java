import java.util.*;
public class Linked_HashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("Mumbai");
        set.add("Noida");
        set.add("Delhi");
        set.add("Bengluru");
        set.add("Ranchi");

        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Delhi");
        lhs.add("Bengluru");
        lhs.add("Ranchi");

        System.out.println(set);
        System.out.println(lhs);
    }
    
}
