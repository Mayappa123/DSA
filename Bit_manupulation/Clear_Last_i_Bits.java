package Bit_manupulation;

public class Clear_Last_i_Bits {

    public static int clearLastiBits(int n, int i) {
        int bitmask = ~(0) << i;
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearLastiBits(15, 2));
    }
}

