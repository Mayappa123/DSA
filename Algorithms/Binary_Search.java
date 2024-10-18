import java.util.*;

public class Binary_Search {
    public static void main(String[] args) {
        int n, i, item, mid=0, c=0, si, ei;
        int a[];

        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements you want ?");
        n = sc.nextInt();
        a = new int[n];

        System.out.println("Enter Elements :");
        for(i=0; i<n; i++)
        a[i] = sc.nextInt();

        System.out.println("Enter item to be found :");
        item = sc.nextInt();
        si=0; ei=n-1;
        
            while(si>=ei){
                mid = (si+ei)/2;
                if(item == a[mid]){
                    System.out.println("item found at "+mid);
                    break;
                }
                    else if(item > a[mid]){
                        si = mid+1;
                    }

               else if(item<a[mid]){
                ei = n-1;
               }
            }

            if(c>0){
                System.out.println("item found at "+mid);
            }

            else{
                System.out.println("item not found.");
            }
        }
    }
