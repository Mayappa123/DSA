public class operatingsystem {
    public static void main(String[] args) {
        
        System.out.print("User.dir : ");
        System.out.println("System property: " + System.getProperty("user.dir"));

       System.out.print("Operating System : ");
       System.out.println(System.getProperty("os.name"));

       System.out.print("Operating System Version : ");
       System.out.println(System.getProperty("os.version"));

       System.out.print("Java Version : ");
       System.out.println(System.getProperty("java.version"));

    }
}
