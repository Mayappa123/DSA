public class Can_Array_Be_sorted {

    public static boolean canSortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1] &&
                        getSetBits(nums[j]) == getSetBits(nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int getSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = { 8, 4, 2, 30, 15 };
        System.out.println(canSortArray(nums)); // true

        int[] nums2 = { 3, 16, 8, 4, 2 };
        System.out.println(canSortArray(nums2)); // false
    }
}
