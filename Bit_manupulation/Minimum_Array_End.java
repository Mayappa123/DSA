// 3133. Minimum Array End

// You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i].
// The result of the bitwise AND operation between all elements of nums is x.
// Return the minimum possible value of nums[n - 1].

public class Minimum_Array_End {

    public static long minEnd(int n, int x) {
        long ans = x;
        n -= 1;
        while (n-- > 0) {
            ans = (ans + 1) | x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 4;

        System.out.println(minEnd(n, x)); // 6
    }
}
