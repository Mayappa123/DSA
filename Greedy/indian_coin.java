import java.util.*;

public class indian_coin {
    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int coinsCount = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= amount) {
                while(coins[i] <= amount) {
                    coinsCount++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total coins used = "+coinsCount);
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
