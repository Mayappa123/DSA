import java.util.*;
import java.io.*;

public class java {

    public static void main(String[] args) {
        
int[] maya = {27, 42, 32, 25, 19};
Arrays.sort(maya);
System.out.println(Arrays.toString(maya));

String[] name = {"John", "15", "Steve", "75", "Adam", "Ben", "95"};
Arrays.sort(name);
System.out.println("String array after sorting in ascending order : " + Arrays.toString(name));

Arrays.sort(name, 0, name.length, Collections.reverseOrder());
System.out.println("String array after sorting in descending order : " + Arrays.toString(name));


    }
}