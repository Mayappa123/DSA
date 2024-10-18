public class Narrowing_Typecasting {
    public static void main(String[] args) {
        int num1;
        double num2 = 20.8;

        // We are assigning larger size datatype 
        // long to smaller size datatype 
        num1 = (int) num2;

        // Print the output 
        System.out.println("The value of num1 is :" + num1);
    }
}    