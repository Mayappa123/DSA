//2825. Make String a Subsequence Using Cyclic Increments

public class Can_Make_Subsequence {
    
    public static boolean canMakeSubsequence(String source, String target) {
        int targetIdx = 0, targetLen = target.length();

        for (char currChar : source.toCharArray()) {
            if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }

    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";

        System.out.println(canMakeSubsequence(str1, str2));  //true
    }
}
