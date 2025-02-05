// 3151. Special Array I
// An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
// You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

public class Special_Array_I {
    public static boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(nums);

    }

    // Input: nums = [1]
    // Output:true
    // Explanation: There is only one element. So the answer is true.

}

