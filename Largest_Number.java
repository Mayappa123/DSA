import java.util.*;

public class Largest_Number {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                String o1 = a + b;
                String o2 = b + a;
                return o2.compareTo(o1);
            }
        });

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Largest_Number ln = new Largest_Number();
        int[] nums = { 3, 30 };
        System.out.println(ln.largestNumber(nums));
    }
}

