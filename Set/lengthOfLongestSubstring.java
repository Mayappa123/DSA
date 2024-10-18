import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int start=0;
        for(int end=0;end<s.length();end++){
           
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                maxLength=Math.max(maxLength,end-start+1);
                
            }else{
                while(s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(s.charAt(start));start++;
                set.add(s.charAt(end));
            }
            
        }
        return maxLength;
    }
    public static void main(String[] args) {
        
        System.out.println(lengthOfLongestSubstring("Mayappa"));
        }

    
}
