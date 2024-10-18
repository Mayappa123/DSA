package Bit_manupulation;

public class Set_ith_bit {

    public static int SetithBit (int n, int i) {
        int bitmask = 1 << i;    
        return n | bitmask;
        
        
    }
    public static void main(String[] args) {
        System.out.println(SetithBit(10, 2));
        
        }
    
}
