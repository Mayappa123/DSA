public class Linear_Search {
    public static int Linear_Search( int arr[], int key) {
        for ( int i = 0; i<arr.length; i++) {
            if ( arr[i] == key) {
                return i;
            }
        }
            
                return -1;
            }
        
            public static void main(String[] args) {
                int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
                int key = 50;
                System.out.println( key + " found at index "+ Linear_Search(arr, key));
            }
        
    

    
}