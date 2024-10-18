public class Stringmethods {
    public static void main(String[] args) {
        String S1 = " RajaRamMohanRoy ";
        System.out.println(S1.length());
       System.out.println(S1.charAt(4));
       System.out.println(S1.toUpperCase());
     System.out.println(S1.toLowerCase());
     System.out.println(S1.substring(7));
     System.out.println(S1.substring(8, 13));
     System.out.println(S1.contains("Ram"));
     System.out.println(S1.startsWith("raja"));
     System.out.println(S1.endsWith("Ram"));
     System.out.println(S1.isEmpty());
     System.out.println(S1.concat("is father of Bengal"));
    } 
    
}
