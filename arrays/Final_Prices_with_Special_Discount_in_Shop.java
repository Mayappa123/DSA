//1475. Final Prices With a Special Discount in a Shop

//You are given an integer array prices where prices[i] is the price of the ith item in a shop.
// There is a special discount for items in the shop. 
//If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. 
//Otherwise, you will not receive any discount at all.
// Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.

import java.util.*;

public class Final_Prices_with_Special_Discount_in_Shop {

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = prices[i];

            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
      int[] prices = {8,4,6,2,3};

      System.out.println(Arrays.toString(finalPrices(prices))); /// [4, 2, 4, 2, 3]
    }
}
