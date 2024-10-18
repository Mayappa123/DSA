public class int_to_string {
    public static void main(String[] args) {

        // by using ValueOf()

        int a = 55;
        int b = 91;

        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        System.out.println(s1);
        System.out.println(s2);

        // by using toString()

        int c = 99;
        int d = 120;

        String s3 = Integer.toString(c);
        String s4 = Integer.toString(d);

        System.out.println(s3);
        System.out.println(s4);

    }
}
