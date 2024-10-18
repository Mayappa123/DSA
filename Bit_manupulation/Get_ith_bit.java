package Bit_manupulation;

public class Get_ith_bit {

    public static int GetithBit (int n, int i) {
        int bitmask = 1 << i;    //Here bit mathches with i .. AND opertor returns 1 if both would 1, else erturns 0.
        if(( n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
        
    }
    public static void main(String[] args) {
        System.out.println(GetithBit(10, 2));
        
        }
        
    
}
