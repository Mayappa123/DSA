import java.util.*;
public class Bubble_Sort {

static void bubblesort( int arr[], int n){
    if(n==1){
        return;
    }
    for( int i=0; i<n-1; i++){

        if( arr[i]> arr[i+1]){

            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;

        }
    }
    bubblesort(arr, n-1);
}

void display( int arr[]){
    for( int i=0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
    }
}


    public static void main(String[] args) {
        Bubble_Sort b1 = new Bubble_Sort();
        int arr[] = { 6, 4, 5, 12, 2, 11, 9};
        bubblesort(arr, arr.length);
        b1.display(arr);
    }
}
