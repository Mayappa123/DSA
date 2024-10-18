public class String_equals {
    public static void main(String[] args) {

        String s1 = "Test123";
        String s2 = "TEST" +123;

if (s1.equalsIgnoreCase(s2)) {
    System.out.println("Both are equal.");
        }

else{
    System.out.println("both are not equql.");
       }
 // Both Strings are equal, ignoring the case of the individual characters.
}

    }

