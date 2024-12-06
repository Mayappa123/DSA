//2554. Maximum Number of Integers to Choose From a Range I

// You are given an integer array banned and two integers n and maxSum. 
//You are choosing some number of integers following the below rules:
// The chosen integers have to be in the range [1, n].
// Each integer can be chosen at most once.
// The chosen integers should not be in the array banned.
// The sum of the chosen integers should not exceed maxSum.
// Return the maximum number of integers you can choose following the mentioned rules.

import java.util.*;

public class Maximum_Number_of_Integers_in_Range {

    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : banned) {
            set.add(num);
        }

        int total = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                total += i;
                if (total <= maxSum)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] banned = { 1, 3, 5 };
        int n = 5;
        int maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum)); // 2

    }
}
