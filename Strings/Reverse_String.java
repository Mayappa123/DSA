public class Reverse_String{
    public static void main(String[] args){
    //Input String
    String str = "Welcome to InterviewBit";
   
    //Pointers.
    int i = 0, j = str.length()-1;
   
    //Result character array to store the reversed string.
    char[] revString = new char[j+1];
   
    //Looping and reversing the string.
    while(i < j){
    revString[j] = str.charAt(i);
    revString[i] = str.charAt(j);
    i++;
    j--;
    }
    //Printing the reversed String.
    System.out.println("Reversed String = " +
   String.valueOf(revString));
    }
   }