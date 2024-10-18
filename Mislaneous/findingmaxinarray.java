import java.util.*;
public class findingmaxinarray {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
int size = sc.nextInt();
int numbers[] = new int[100];
//input
for(int i=0; i<100; i++) {
numbers[i] = sc.nextInt();
}
int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
for(int i=0; i<numbers.length; i++) {
if(numbers[i] < min) {
min = numbers[i];
}
if(numbers[i] > max) {
max = numbers[i];
      }
     }
    }
}
