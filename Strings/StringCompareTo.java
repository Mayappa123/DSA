
import java.util.*;
public class StringCompareTo {
    public static void main(String[] args) {
        Scanner SC = new Scanner ( System.in);

        System.out.println(" Enter first number....");
        String s1 = SC.next();

        System.out.println(" Enter second number....");
        String s2 = SC.next();

        int result = s1.compareTo(s2);

        if( result == 0)
        System.out.println("s1 is equal to s2.");

        else if (result < 0) {
            System.out.println("s1 is less than s2.");
            
        } else {

            System.out.println("s1 is greater than s2.");
        }
    }
    
}
