public class mutabledemo {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("sachin");
       // StringBuilder s2 = new StringBuilder("Dhoni");//
       System.out.println(s1.capacity());
       System.out.println(s1.length());
       System.out.println(s1.append(" is a good batsman."));
       System.out.println(s1.capacity());
       System.out.println(s1.length());

        
    }
    
}
