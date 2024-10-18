package Bit_Manipulation;
import java.util.*;
public class Update_Bit {
     public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int operation = sc.nextInt();
      int number = 5;
      int position = 1;
      int bitmask = 1<<position;

      if(operation == 1){
        //set bit
        int newmber = bitmask | number;
        System.out.println(newmber);
      }

      else{
        //clear bit
        int newbitmask = ~(bitmask);
        int newnumber = newbitmask & number;
        System.out.println(newnumber);
      }
     }
}
