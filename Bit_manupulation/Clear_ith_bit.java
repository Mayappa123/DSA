package Bit_manupulation;

public class Clear_ith_bit {

    public static int ClearithBit (int n, int i) {
        int bitmask = ~(1 << i);    //Here bit mathches with i .. AND opertor returns 1 if both would 1, else erturns 0.
        return n & bitmask;
        
    }
    public static void main(String[] args) {
        System.out.println(ClearithBit(15, 2));
        
        }
}
