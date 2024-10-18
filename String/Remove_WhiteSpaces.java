public class Remove_WhiteSpaces {

    public static void main(String[] args) {
        String str = "This is too much better";
        System.out.println("Original Sentences -->"+str);

        str = str.replaceAll("s\\", "");
        System.out.println("After replacement -->"+str);
    }
    
}
