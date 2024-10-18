
    
public class Find_Misssing_Number {
    public static void main(String[] args) {

    int[] array={4,3,8,7,1,2,6};
    int missingNumber = findMissingNum(array);
    System.out.println("Missing Number is "+ missingNumber);
    }

    public static int findMissingNum(int[] array) {
    int n=array.length+1;
    int sumOfFirstNNums=n*(n+1)/2;
    int actualSumOfArr=0;
    for (int i = 0; i < array.length; i++) {
    actualSumOfArr+=array[i];
    }
    return sumOfFirstNNums-actualSumOfArr;
    }
   }