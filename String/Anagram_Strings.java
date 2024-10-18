import java.util.Arrays;

public class Anagram_Strings {

    public static void main(String[] args) {
        String s1, s2;
        s1 = "race";
        s2 = "care";

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(s1.length() == s2.length()) {
            char[] str1 = s1.toCharArray();
            char[] str2 = s2.toCharArray();
        
            
            Arrays.sort(str1);
            
            Arrays.sort(str2);

            boolean result = Arrays.equals(str1, str2);
            if(result) {
                System.out.println(s1+" and "+s2+" are anagram to each other.");
            }
            else {
                System.out.println(s1+" "+s2+" are not an anagram to each other.");
            }
        }
        else {
            System.out.println("Both are not an anagram to each other.");
        }
    }
    
}
