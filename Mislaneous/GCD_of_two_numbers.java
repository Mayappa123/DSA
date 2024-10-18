public class GCD_of_two_numbers {
    public static void main(String[] args) {
        int a= 555;
        int b= 275;

        int gcd = 1;

        for ( int i=1; i<=a && i<=b; i++) 
            if ( a%i ==0 && b%i==0){
                   gcd=i;            
                }
                System.out.println("Greatest Common Divisor of a and b is" + " " +gcd+".");

        }
    }

