import java.util.*;

//Given a string expression of numbers and operators,return all possible results from computing all the different possible ways to group numbers and operators.
//You may return the answer in any order.

//The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

public class LeetCode_241 {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (ch == '+') {
                            list.add(a + b);
                        } else if (ch == '-') {
                            list.add(a - b);
                        } else if (ch == '*') {
                            list.add(a * b);
                        }
                    }
                }
            }

        }
        if (list.isEmpty()) {
            list.add(Integer.parseInt(expression));
        }
        return list;

    }

    public static void main(String[] args) {
        LeetCode_241 leet = new LeetCode_241();

        System.out.println(leet.diffWaysToCompute("11-2+5"));
    }
}
