import java.util.HashSet;
import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        // Add elements in set....
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        System.out.println(set);

        // Print size of set....
        System.out.println("The size of set is "+set.size());

        // Remove element from set....
        set.remove(4);

        // Check whether element contains in set or not....6\j
        if(!set.contains(5)) {
            System.out.println("Set not comtains 5.");
        } else {
            System.out.println("Set contains 5.");
        }

        //Iterator
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        
    }
}