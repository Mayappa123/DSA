
import java.util.*;

public class Max_Count_of_Unique_Substrings_in_String {

    public static int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private static int backtrack(String s, int start, HashSet<String> set) {
        if (start == s.length()) {
            return set.size();
        }

        int count = 0;

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            if (!set.contains(substring)) {
                set.add(substring);
                count = Math.max(count, backtrack(s, i, set));
                set.remove(substring);
            }
            System.out.println(set);

        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(maxUniqueSplit("ababccc"));
    }
}
