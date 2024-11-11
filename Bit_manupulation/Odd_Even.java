package Bit_manupulation;

public class Odd_Even {
    public static void OddEven (int n) {
        int bitmask = 1;
        if((n & bitmask) == 0) {
            // Even
            System.out.println("Number is even.");
        } else {
            System.out.println("Number is odd.");
        }
    }

    public static void main(String[] args) {
        OddEven(3);
        OddEven(4);
        
    }
    // Contains_Duplicate_III.java
}
