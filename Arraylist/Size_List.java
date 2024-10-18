package Arraylist;

import java.util.ArrayList;
public class Size_List {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //  ArrayList can be created in 3 ways.

// a) ArrayList() —> It creates an empty ArrayList with initial capacity of 10.

// b) ArrayList(int initialCapacity) —> It creates an empty ArrayList with supplied initial capacity.

// c) ArrayList(Collection c) —> It creates an ArrayList containing the elements of the supplied collection.


     

        
        list1.add(15);
        list1.add(25);
        list1.add(35);
        list1.add(45);
        list1.add(55);
        list1.add(65);
        list1.add(75);

        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        list2.add(60);
        list2.add(70);
        
        int b = list2.size();
        System.out.println(b);
        System.out.println(list2);

        int a = list1.size();
        System.out.println(a);
        System.out.println(list2);
        
        list1.addAll(list2);
        System.out.println(list1);

        list1.addAll(2, list2);
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("sachin");
        list3.add("rakesh");
        list3.add("anuja");
        list3.add("rakesh");
        list3.add("pallavi");
        list3.add("saket");
        list3.add("priyanka");

        System.out.println(list3);










    }

}
