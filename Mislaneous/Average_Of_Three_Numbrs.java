import java.util.*;
public class Average_Of_Three_Numbrs {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in);
        System.out.println("Enter first number");
        double a = sc.nextDouble();
        System.out.println("Enter second number");
        double b = sc.nextDouble(); 
        System.out.println("Enter third number");
        double c = sc.nextDouble();

        System.out.println("The average of three numbers = " + average(a, b, c)+"\t" );

    }
    public static double average ( double a, double b, double c) {
    return ( a+b+c)/3;

}
}