public class Palindrome_String {

    public static void main(String[] args) {
        String str = "Radar";
        String reversedStr = "";
        int n = str.length() - 1;

        for (int i = n; i >= 0; --i) {
            reversedStr = reversedStr + str.charAt(i);
        }
        if (str.equalsIgnoreCase(reversedStr)) {
            System.out.println(str + " is a palindrome String.");
        } else {
            System.out.println(str + " is not a palindrome String.");

        }

    }

}
