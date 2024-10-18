class oddnumbersbetween1and100
{
public static void main(String args[])
{
int sum = 0;
for(int i = 0;i <= 100;i++)
{
if(i % 2 != 0)
{
sum++;
}
}
System.out.println("The Count Of Odd Numbers are:" + sum);
}
}
