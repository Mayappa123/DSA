package arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Arraylist_1 {
    public static void main(String[] args) {
        ArrayList <String> maya = new ArrayList<String>();
        maya.add("Ram");
        maya.add("Nikita");
        maya.add("Radhika");
        maya.add("Ganesh");
        maya.add("Sonali");
        maya.add("Sayali");
        maya.add("Rohit");
        System.out.println(maya);

        //display element of given index //
        String a = maya.get(4);
        System.out.println(a); 


       // remove element of given index //
       maya.remove(5);
       System.out.println(maya);


       //add elements at given index //
       maya.add(4, "Bai");
       System.out.println(maya);


       // Display size of array //
       int size = maya.size();
       System.out.println(size);


       // change element at given index //
       maya.set(0,"janjira");
       System.out.println(maya);


       Collections.sort(maya);
       System.out.println(maya);

       






    }
}
