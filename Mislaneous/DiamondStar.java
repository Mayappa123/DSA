import java.util.Scanner;
public class DiamondStar{
   public static void main(String args[]){
      int i, j, k, my_input;
      System.out.println("Required packages have been imported");
      Scanner my_scanner = new Scanner(System.in);
      System.out.println("A reader object has been defined ");
      System.out.print("Enter the number : ");
      my_input = my_scanner.nextInt();
      k = my_input - 1;
      System.out.println("The diamond star pattern : ");
      for (j = 1; j<= my_input; j++){
         for (i = 1; i<= k; i++){
            System.out.print(" ");
         }
         k--;
         for (i = 1; i <= 2 * j - 1; i++){
            System.out.print("*");
         }
         System.out.println("");
      }
      k = 1;
      for (j = 1; j<= my_input - 1; j++){
         for (i = 1; i<= k; i++){
            System.out.print(" ");
         }
         k++;
         for (i = 1; i<= 2 * (my_input - j) - 1; i++){
            System.out.print("*");
         }
         System.out.println("");
      }
   }
}
