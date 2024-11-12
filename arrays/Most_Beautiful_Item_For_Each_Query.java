import java.util.*;

public class Most_Beautiful_Item_For_Each_Query {

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price. If prices are the same, sort by beauty descending.
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Preprocess items to create a max beauty list up to each price
        List<int[]> maxBeautyByPrice = new ArrayList<>();
        int maxBeauty = 0;

        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            maxBeautyByPrice.add(new int[] { item[0], maxBeauty });
        }

        // Create result array to store answers to each query
        int[] result = new int[queries.length];
        int[][] queryWithIndex = new int[queries.length][2];

        // Attach index to each query for restoring order
        for (int i = 0; i < queries.length; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }

        // Sort queries in ascending order by query price
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);

        // Process each query
        int idx = 0;
        for (int[] q : queryWithIndex) {
            int queryPrice = q[0];
            int originalIndex = q[1];

            // Use binary search to find the maximum beauty for price <= queryPrice
            while (idx < maxBeautyByPrice.size() && maxBeautyByPrice.get(idx)[0] <= queryPrice) {
                idx++;
            }

            // If idx is 0, no price <= queryPrice was found, else use the last valid beauty
            result[originalIndex] = idx > 0 ? maxBeautyByPrice.get(idx - 1)[1] : 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        int[] queries = { 1, 2, 3, 4, 5, 6 };

        // Print the result array using Arrays.toString()
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }
}
