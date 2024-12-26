public class Target_Sum {

    public static int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    public static int helper(int[] arr, int target, int idx, int sum) {
        if (idx >= arr.length)
            return sum == target ? 1 : 0;

        int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
        int add = helper(arr, target, idx + 1, sum + arr[idx]);

        return subtract + add;
    }

    public static void main(String[] args) {
        in[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(findTargetSumWays(null, target));
    }
}
