public class Clear_Digits {

    public static String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1); // Remove last char
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "44cg";
        System.out.println(clearDigits(s));
    }
}
