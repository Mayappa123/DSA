//1346. Check If N and Its Double Exist



import java.util.*;

public class Check_if_N_and_its_Double_exists {
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 7, 12, 5, 6, 1 };
        System.out.println(checkIfExist(nums));  //true
    }
}
