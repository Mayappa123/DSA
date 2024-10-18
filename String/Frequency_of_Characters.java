public class Frequency_of_Characters {

    public static void main(String[] args) {
        String str = "My name is mayappa.";
        char ch = 'p';
        int frequency = 0;

        for(int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i)) {
                frequency++;
            }
        }

        System.out.println("Frequency of " + ch + " = " + frequency);
    }
}
    
    

