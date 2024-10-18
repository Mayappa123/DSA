package Bit_Manipulation;
import java.util.*;
public class Get_Bit {

    public static void main(String[] args) {
        int n = 7;
        int a = 1;
        int bitmask = 1<<a;

        if((bitmask & a) == 0 ){
            System.out.println(" bit is zero.");
        }
        else{
            System.out.println("bit is one.");
        }


    
   }
}
