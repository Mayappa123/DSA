import java.util.*;
public class Half_Pyramid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How much rows you want...");
        int a= sc.nextInt();
        for (int i=1; i<= a; i++)
        {
            for (int j= 1; j<=i; j++)
            {
           System.out.print(j+ "");
    }
    for (int j= i-1; j>=i; j--)
   
    {
        System.out.print(j+"");
    }
    System.out.println();

    sc.close();
    }
}
}
