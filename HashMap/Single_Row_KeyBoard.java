//Imagine you have a special keyboard with all keys in a single row. 
//The layout of characters on a keyboard is denoted by a string keyboard of length 26. 
//Initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. 
//The time taken to move your finger from index i to index j is abs(j - i).
//Given a string keyboard that describe the keyboard layout and a string text, return an integer denoting the time taken to type string text.

import java.util.HashMap;
import java.util.Map;

public class Single_Row_KeyBoard {

    public static int calculateTime(String keyboard, String word) {

        Map<Character, Integer> hashmap = new HashMap<Character, Integer>();
        for (int i = 0; i < keyboard.length(); i++) {
            hashmap.put(keyboard.charAt(i), i);
        }

        int diff = hashmap.get(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            int n = hashmap.get(word.charAt(i));
            int m = hashmap.get(word.charAt(i - 1));
            System.out.println("n = " + n + " m = " + m);
            diff = diff + Math.abs(n - m);
        }

        return diff;
    }

    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxy", text = "cba";
        int time = calculateTime(keyboard, text);

        System.out.println(time);

    }
}
