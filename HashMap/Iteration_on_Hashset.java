import java.util.*;
public class Iteration_on_Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        // Using Iterator
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }

        
        // Advance for each loop
        for(Integer num : set) {
            System.out.print(num+" ");
        }
    }
    
}
