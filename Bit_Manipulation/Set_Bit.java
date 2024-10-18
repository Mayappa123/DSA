package Bit_Manipulation;

public class Set_Bit {

     public static void main(String[] args) {
        int n = 5;
        int a = 2;
        int bitmask = 1<<a;
        int newbit = bitmask | n;
        System.out.println(newbit);
     }
}
