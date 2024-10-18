import java.util.StringTokenizer;
public class string_tokanizer {
    public static void main(String[] args) {
        
        StringTokenizer s1 = new StringTokenizer("apple ball cat dog", " "); 
        while (s1.hasMoreTokens()) {
            System.out.println(s1.nextToken());
            System.out.println();

            StringTokenizer s2 = new StringTokenizer("apple, ball, cat, dog", ", "); 
        while (s2.hasMoreTokens()) {
            System.out.println(s2.nextToken());
            }
            
        }
    }
} 
    
   
    

