package Bit_Manipulation;

public class Clear_Bit {
    public static void main(String[] args) {
        int n = 5;
        int a = 2;
        int bitmask = 1<<a;
        int newbitmask = ~(bitmask);
        int newbit = newbitmask & n;
        System.out.println(newbit);
    }
   
}
