//You are given an integer n indicating there are n specialty retail stores. There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, where quantities[i] represents the number of products of the ith product type.

// You need to distribute all products to the retail stores following these rules:

// A store can only be given at most one product type but can be given any amount of it.
// After distribution, each store will have been given some number of products (possibly 0). Let x represent the maximum number of products given to any store. You want x to be as small as possible, i.e., you want to minimize the maximum number of products that are given to any store.
// Return the minimum possible x.

// Example 1:
// Input: n = 6, quantities = [11,6]
// Output: 3
// Explanation: One optimal way is:
// - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
// - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
// The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.

public class Minimized_Maximum_Distribution_Products_Per_Store {

    public static int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;

        for (int quantity : quantities) {
            right = Math.max(right, quantity); // Set the initial upper bound to max quantity
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; // If feasible, try for a smaller maximum
            } else {
                left = mid + 1; // If not feasible, increase the minimum bound
            }
        }

        return left;
    }

    private static boolean canDistribute(int[] quantities, int n, int maxProductsPerStore) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            // Equivalent to Math.ceil(quantity / maxProductsPerStore)
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore;
        }
        return requiredStores <= n;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = { 11, 6 };

        int ans = minimizedMaximum(n, quantities);
        System.out.println(ans);
    }
}
