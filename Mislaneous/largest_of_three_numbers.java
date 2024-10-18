import java.util.*;
public class largest_of_three_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter the value of A");
        int a = sc.nextInt();

        System.out.println("Enter the value of B");
        int b = sc.nextInt();

        System.out.println("Enter the value of C");
        int c = sc.nextInt();

if ( a>b && a>c){
    System.out.println("A is greater.");
}
else if ( b>a && b>c){
    System.out.println("B is greater.");
}
else{
    System.out.println("C is greater.");
}

    }
    
}
