package Map;

import java.util.*;

public class Valid_Perentheses {

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '(' || s.charAt(idx) == '{' || s.charAt(idx) == '[') {
                stack.push(s.charAt(idx));
                continue;
            }
            if (stack.size() == 0 || map.get(s.charAt(idx)) != stack.pop()) {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }

}
