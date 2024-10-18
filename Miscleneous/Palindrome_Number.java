package Miscleneous;

public class Palindrome_Number {

    public static void main(String[] args) {
        int num = 3553;
        int reversedNum = 0;
        int remainder;

        int OriginalNum = num;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            reversedNum = reversedNum * 10 + remainder;

        }

        if (reversedNum == OriginalNum) {
            System.out.println(OriginalNum + " is a palindrome number.");
        }

        else {
            System.out.println(OriginalNum + " is not a palindrome number.");
        }
    }
}
