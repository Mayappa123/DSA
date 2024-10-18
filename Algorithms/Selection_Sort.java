public class Selection_Sort {
    void selectionsort( int arr []){
        int pos;
        int temp;

        for( int i = 0; i<arr.length; i++){
            pos = i;
            for( int j = i+1; j<arr.length; j++){
                if( arr[j] < arr[pos]){
                    pos = j;
                }
            }

            temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;

        }
    }

    void display( int arr[]){
        for( int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Selection_Sort s1 = new Selection_Sort();
        int arr[] = { 64, 25, 12, 22, 11};
        s1. selectionsort(arr);
        s1.display(arr);
    }
}
