public class Update_on_ST {

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

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if(idx > sj || idx < si) {
            return;
        }

        tree[i] += diff;
        if(si != sj) { //Non leaf
            int mid = (si + sj)/2;
            updateUtil(2*mid+1, si, mid, idx, diff); //Left
            updateUtil(2*mid+2, mid+1, sj, idx, diff); // Right
        }

    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff); //Segment Tree Updation
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        initialize(n);
        BuildTree(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        update(arr, 2, 2);
        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

    }
    
}
