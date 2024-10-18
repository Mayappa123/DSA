public class Capitalize_First_Letter {

    public static void main(String[] args) {

        String str = "india";
        String firstletter = str.substring(0, 1);
        String remaining = str.substring(1, str.length());
        String capitalized = firstletter.toUpperCase() + remaining;
        System.out.println(capitalized);

    }

}
