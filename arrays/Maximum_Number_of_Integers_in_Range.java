import java.util.HashSet;

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
        System.out.println(maxCount(banned, n, maxSum));

    }
}
