import java.util.*;
public class Count_Distinct_Elements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 3, 6, 7, 1, 2};

        HashSet<Integer> set = new HashSet<Integer>();
         for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
            System.out.println("Ans = "+set.size());
            
         }
    }
    
}
