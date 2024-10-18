import java.util.Arrays;
public class Jaggedarray {
   public static void main(String args[]){
      //Array with 3 rows and variable columns
      int[][] myArray = new int[3][];
      //0th row with 2 columns
      myArray[0] = new int[2];
      //1st row with 5 columns
      myArray[1] = new int[5];
      //2nd row with 4 columns
      myArray[2] = new int[4];
      //Populating 0th row
      myArray[0][0] = 21;
      myArray[0][1] = 22;
      //Populating 1st row
      myArray[1][0] = 24;
      myArray[1][1] = 25;
      myArray[1][2] = 26;
      myArray[1][3] = 27;
      myArray[1][4] = 28;
      //Populating 2nd row
      myArray[2][0] = 29;
      myArray[2][1] = 30;
      myArray[2][2] = 31;
      myArray[2][3] = 32;
      for(int i=0; i<myArray.length; i++ ){
         System.out.println(Arrays.toString(myArray[i]));
      }
   }
}