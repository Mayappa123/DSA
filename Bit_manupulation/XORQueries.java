//LeetCode 1310. XOR Queries of a Subarray

public class XORQueries {
    static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] temp = new int[n];
        temp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            temp[i] = temp[i - 1] ^ arr[i];
        }

        int[] res = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];

            if (i == 0) {
                res[k] = temp[j];
            } else {
                res[k] = temp[j] ^ temp[i - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };

        int[] result = xorQueries(arr, queries);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
