package Map;

import java.util.Enumeration;
import java.util.Hashtable;

public class hashtable {

    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // put()
        hashtable.put("a", 1);
        hashtable.put("b", 2);
        hashtable.put("c", 3);
        hashtable.put("d", 4);
        System.out.println(hashtable);

        // Size()
        int a = hashtable.size();
        System.out.println(a);

        // get()
        Integer b = hashtable.get("a");
        System.out.println(b);

        // isEmpty()
        boolean c = hashtable.isEmpty();
        System.out.println(c);

        // clone()
        System.out.println(hashtable.clone());

        // toString()
        System.out.println(hashtable.toString());

        // values()
        System.out.println(hashtable.values());

        // keys()
        // The java.util.Hashtable.keys() method of Hashtable class in Java is used to
        // get the enumeration of the keys present in the hashtable.
        Enumeration enu = hashtable.keys();
        while (enu.hasMoreElements()) {
            System.out.print(enu.nextElement() + " ");
        }
        System.out.println();

        // remove()
        hashtable.remove("a");
        System.out.println(hashtable);

        // computeIfAbsent()
        hashtable.computeIfAbsent("e", (k) -> 5);
        System.out.println(hashtable);

        // putIfAbsent()
        String retValue = String.valueOf(hashtable.putIfAbsent("a", 1));
        System.out.println(hashtable);

        // forEach()
        hashtable.forEach((k, v) -> {
            v = v + 100;
            hashtable.replace(k, v);
        });
        System.out.println(hashtable);

    }

}
