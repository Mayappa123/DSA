package Bit_manupulation;

public class Update_ith_bit {

    public static int ClearithBit (int n, int i) {
        int bitmask = ~(1 << i);    //Here bit mathches with i .. AND opertor returns 1 if both would 1, else erturns 0.
        return n & bitmask;
        
    }

    public static int SetithBit (int n, int i) {
        int bitmask = 1 << i;    
        return n | bitmask;
        
    }

    public static int UpdateIthBit (int n, int i, int newBit) {
        if(newBit == 0) {
            return ClearithBit(n, i);
            }
            else {
                return SetithBit(n, i);
        }
    }
    //OR
    
    public static int UpdateithBit (int n, int i, int newBit) {
        n = ClearithBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
        }

        public static void main(String[] args) {
            System.out.println(UpdateIthBit(10, 2, 1));
            System.out.println(UpdateithBit(10, 2, 1));
        }
}
