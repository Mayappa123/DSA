import java.util.Scanner;


public class rectangularpattern2
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many rows you want in this pattern?");
        int rows = sc.nextInt();
        System.out.println("Here is your patten...");
         for(int i = 1; i<= rows; i++)
        {
            for(int j=1; j <= rows; j++)
            {
        
            if(j%2==0)
            {
               
            System.out.print( "0 " );
            }
                else{
                    System.out.print( "1 " );
                }  
            }
                        
            
            System.out.println();
        }
        sc.close(); 
        
    }
}
        
         