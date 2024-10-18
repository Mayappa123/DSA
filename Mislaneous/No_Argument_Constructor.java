
class Rectangle
{
    double length;
    double breadth;
 
    Rectangle()
    {
        length = 15.5;
        breadth = 10.67;
    }
    double calculateArea()
    {return length*breadth;}
}
 
class Rectangle_Main {
    public static void main(String[] args) {
        double area;
        Rectangle myrec = new Rectangle();
        area = myrec.calculateArea();
        System.out.println("The area of the Rectangle: " +area); 
    }
}
