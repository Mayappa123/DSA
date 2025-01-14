package Bit_manupulation;

public class Bit_Operations {

    //Least Significant Bit --> It is rightmost bit.
    //Most Significant Bit --> It is leftmost bit.


    //If MSB is 1 --> Negative number 
    //If MSB is 0 --> Positive number

    //2"s complement --> Add 1 in 1"s complement.

    //Binary Left Shift Operator (<<)....
    // a << b i.e. shifting the digits of a towards left by b places.
    // Formula --> a << b = a * 2^b

    //Binary Right Shift Operator (>>)....
    // a >> b i.e. shifting the digits of a towards right by b places.
    // Formula --> a >> b = a / 2^b

    public static void main(String[] args) {
        //  AND Operator
        // 0 & 0 -->> 1
        // 0 & 1 -->> 0
        // 1 & 0 -->> 0
        // 1 & 1 -->> 1
        System.out.println(5 & 6);


        //  OR Operator
        // 0 | 0 -->> 0
        // 0 | 1 -->> 1
        // 1 | 0 -->> 1
        // 1 | 1 -->> 1
        System.out.println(5 | 6);


        //XOR Operator -- Same bits gives 0.
        // 0 ^ 0 -->> 0
        // 0 ^ 1 -->> 1
        // 1 ^ 0 -->> 1
        // 1 ^ 1 -->> 0
        System.out.println(5 ^ 6);

        //NOT Operator i.e. Binary Ones Complement
        //~0 -->> 1
        //~1 -->> 0

        System.out.println(~5);

        //Binary Left Shift
        System.out.println(5 << 2);

        //Binary Right Shift
        System.out.println(5 >> 2);
    }
    
}
