 

public class Creation_Of_ST {

    static int tree[];

    public static void initialize(int n) {
        tree = new int[4*n];
    }

    public static int BuildTree(int arr[], int i, int start, int end) {  // i --> Segment Tree Index
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        BuildTree(arr, 2*i+1, start, mid);  // 2+i+1 --> Left node index
        BuildTree(arr, 2*i+2, mid+1, end);  // 2+i+2 --> Right node index
        tree[i] = tree[2*i+1] + tree[2*i+2];

        return tree[i];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        initialize(n);
        BuildTree(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

    }
    
}
