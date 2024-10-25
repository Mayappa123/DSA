//LeetCode 1233. Remove Sub-Folders from the Filesystem
//Remove sub-words from dictionary...

import java.util.*;

public class Remove_SubStrings {
    public static List<String> removeSubStrings(String[] dictionary) {
        List<String> ans = new ArrayList<>();

        ans.add(dictionary[0]);

        for (int i = 1; i < dictionary.length; i++) {
            String s = ans.get(ans.size() - 1) + "/";

            if (!dictionary[i].startsWith(s)) {
                ans.add(dictionary[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] dictionary = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };

        List<String> result = removeSubStrings(dictionary);
        System.out.println(result); // Output: ["/a", "/c/d", "/c/f"]
    }
}
