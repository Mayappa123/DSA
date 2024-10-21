import java.util.*;

public class Max_Count_of_Unique_Substrings_in_String {

    public static int maxUniqueSplit(String s) {
        List<String> result = new ArrayList<>(); 
        int maxLength = backtrack(s, 0, new HashSet<>(), new ArrayList<>(), result);

        System.out.println("Unique substrings: " + result);
        return maxLength;
    }

    private static int backtrack(String s, int start, HashSet<String> set, List<String> currentList,
            List<String> result) {
        if (start == s.length()) {
            if (currentList.size() > result.size()) {
                result.clear();
                result.addAll(currentList);
            }
            return set.size();
        }

        int count = 0;

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            if (!set.contains(substring)) {
                set.add(substring);
                currentList.add(substring);

                count = Math.max(count, backtrack(s, i, set, currentList, result));

                set.remove(substring);
                currentList.remove(currentList.size() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int maxLength = maxUniqueSplit("ababccc");
        System.out.println("Maximum number of unique substrings: " + maxLength);
        System.out.println();
        int Length = maxUniqueSplit("aba");
        System.out.println("Maximum number of unique substrings: " + Length);
    }
}
