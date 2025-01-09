nm

    import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        // add
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(5);

        System.out.println(set);

        // containsKey
        if(set.contains(2)) {
            System.out.println("set contains 2");
        }
        else {
            System.out.println("not contains");
        }

        // remove
        set.remove(2);
        if(set.contains(2)) {
            System.out.println("set contains");
        }
        else {
            System.out.println("not contains 2");
        }

        // size
        int a = set.size();
        System.out.println(a);

        // clear
        set.clear();
        int b = set.size();
        System.out.println(b);

        // isEmpty()
        System.out.println(set.isEmpty());
    }
}
