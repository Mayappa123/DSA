package Recursion;

public class Print_numbers_from_1_to_5 {
    public static void Printnumbers(int n){
        if(n ==6){
            return;
        }
        System.out.print(" "+n);
        Printnumbers(n+1);
    }
    
    public static void main(String[] args) {
        int n = 1;
        Printnumbers(n);
    }
}
