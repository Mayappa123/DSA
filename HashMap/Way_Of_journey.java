import java.util.*;
public class Way_Of_journey {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap< String, String> revMap = new HashMap<>();

        for(String Key :tickets.keySet()) {
            revMap.put(tickets.get(Key), Key);
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
        
    }
    public static void main(String[] args) {

        HashMap< String, String> tickets = new HashMap<String,String>();
        tickets.put("Chennai", "Bengluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);

       for(String key : tickets.keySet()) {
        System.out.print(" -> "+ tickets.get(start));
        start = tickets.get(start);
       }
       System.out.println();
          
    }
    
}
