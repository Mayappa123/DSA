import java.util.*;
import java.io.*;

public class jagg_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int maya[][] = new int[a][];

        for (int i = 0; i < maya.length; i++)
            maya[i] = new int[i + 1];

        int temp = 1;
        for (int i = 0; i < maya.length; i++)
            for (int j = 0; j < maya[i].length; j++)
                maya[i][j] = temp++;

        System.out.println(" Elements of 2D jagged array for n = " + a);

        for (int i = 0; i < maya.length; i++) {
            for (int j = 0; j < maya[i].length; j++) {
                System.out.print(maya[i][j] + "   ");
            }

            System.out.println();

        }
        sc.close();
    }
}