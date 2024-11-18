import java.util.Arrays;

public class Defuse_Bomb {

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            Arrays.fill(result, 0);
        } else {
            for (int i = 0; i < n; i++) {
                int sum = 0;

                if (k > 0) {
                    for (int j = 1; j <= k; j++) {
                        sum += code[(i + j) % n];
                    }
                } else {
                    for (int j = 1; j <= -k; j++) {
                        sum += code[(i - j + n) % n];
                    }
                }

                result[i] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 1, 4 };
        int k = 3;

        System.out.println(Arrays.toString(decrypt(nums, k))); // [12,10,16,13]
    }
}

// 1652. Defuse the Bomb

// You have a bomb to defuse, and your time is running out !
// Your informer will provide you with a circular array code of length of n and
// a key k.

// To decrypt the code, you must replace every number. All the numbers are
// replaced simultaneously.

// If k > 0, replace the ith number with the sum of the next k numbers.
// If k < 0, replace the ith number with the sum of the previous k numbers.
// If k == 0, replace the ith number with 0.
// As code is circular, the next element of code[n-1] is code[0], and the
// previous element of code[0] is code[n-1].

// Given the circular array code and an integer key k, return the decrypted code
// to defuse the bomb!
