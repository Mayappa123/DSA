//LeetCode 1233. Remove Sub-Folders from the Filesystem
//Remove sub-words from dictionary...

import java.util.*;

public class Remove_SubStrings {
    public static List<String> removeSubStrings(String[] dictionary) {
        Arrays.sort(dictionary);

        List<String> result = new ArrayList<>();

        result.add(dictionary[0]);

        for (int i = 1; i < dictionary.length; i++) {
            String lastAdded = result.get(result.size() - 1);

            if (!dictionary[i].startsWith(lastAdded + "/")) {
                result.add(dictionary[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] dictionary = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };

        List<String> result = removeSubStrings(dictionary);
        System.out.println(result); // Output: ["/a", "/c/d", "/c/f"]
    }
}
