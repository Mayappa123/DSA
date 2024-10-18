import java.io.BufferedReader;
import java.io.InputStreamReader;
public class GeneratePyramidExamaple {
public static void main (String[] args) throws Exception{
BufferedReader keyboard = new BufferedReader (new
InputStreamReader(System.in));
System.out.println("Enter Number:");
int a= Integer.parseInt (keyboard.readLine());
System.out.println("Enter X:");
int x= Integer.parseInt (keyboard.readLine());
int y = 0;
for(int i=0; i<= a ;i++){

for(int j=1; j <= i ; j++){
System.out.print(y + "\t");
y = y + x;
}
System.out.println("");
}
}
}