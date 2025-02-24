
//Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
//You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

import java.util.*;

public class LeetCode_386 {
    public List<Integer> LexicographicalNumbers(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, (a, b) -> (Integer.toString(a).compareTo(Integer.toString(b))));
        return list;
    }

    public static void main(String[] args) {
        LeetCode_386 leetCode_386 = new LeetCode_386();

        System.out.println(leetCode_386.LexicographicalNumbers(20));
        // [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 3, 4, 5, 6, 7, 8, 9]
    }
}
