public class PrimeNumbersUptoN
{
public static void main(String[] args)
{
int num =0, i =0;
System.out.println("Prime numbers from 1 to 100 are :");
 for (i = 1; i <= 1000; i++)
 {
 int counter=0;
 for(num =i; num>=1; num--)
 {
 if(i%num==0)
 {
 counter = counter + 1;
 }
}
if (counter ==2)
 {
 System.out.print(i+" ");
 }
 }
 }
}
