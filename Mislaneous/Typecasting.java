public class Typecasting {
    public static void main(String[] args) {

        int x= 9;

        long y=x;

        float z=y;

        System.out.println("before conversion int value = " +x);

        System.out.println("after conversion long value = " +y);

        System.out.println("after conversion float value = " +z);


    }
}
  
 class maya extends Typecasting {
    public static void main(int[] args) {

        double a= 166.66;

        long b=(long) a;

        int c=(int) b;

        System.out.println("before conversion int value = " +a);

        System.out.println("after conversion long value = " +b);

        System.out.println("after conversion float value = " +c);


    }
}
