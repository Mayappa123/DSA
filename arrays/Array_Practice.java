package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Practice {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int[][] a = new int[8][5]; // Throws java.lang.NegativeArraySizeException
        System.out.println(a.length); // Prints 0 in this case.

        int[][] b = { { 1, 2 }, { 3, 4 }, { 5, 6 }, {,} };
        System.out.println(b.length); // Prints 0 in this case.

        int[][] c = { { 1 }, { 2, 3 }, null };
        System.out.println(c.length); // Prints 0 in this case.

        int[] d; // Array declaration - uninitialized
        d = new int[3]; // Initialize array - { 0, 0, 0 }
        d[0] = 10; // Set index 0 value - { 10, 0, 0 }
        d[1] = 20; // Set index 1 value - { 10, 20, 0 }
        d[2] = 30;
        System.out.println(d.length);

        int[] e = new int[] { 1, 2, 3 };
        for (int i : e) {
            System.out.print(i + " ");

            int[] f = new int[] { 4, 5, 6 };
            for (int j : f) {
                System.out.print(j + " ");
                System.out.println();

                String[] stringArray = { "foo", "bar", "baz" };
                List<String> stringList = new ArrayList<>(Arrays.asList(stringArray));
                System.out.println(stringList);

            }

        }
    }

}
