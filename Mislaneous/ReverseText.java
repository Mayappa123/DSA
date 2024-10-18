import java.util.*;

public class ReverseText {
public static void main(String[] args) {

String name="maya";
System.out.println("Original Name: "+name);
System.out.println("After Reverse: " );
for(int i=name.length()-1; i>=0; i--)
{
System.out.print(name.charAt(i));
}
}
}

