public class Best_Sightseeing_Pair {
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int m = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + m > ans)
                ans = values[i] - i + m;

            if (values[i] + i > m)
                m = values[i] + i;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] valuse = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(valuse));
    }
}
