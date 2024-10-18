public class Min_ST {

    static int tree[];

    public static void initalize(int n) {
        tree = new int[4*n];
    }

    public static void buildTree(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj)/2;
        buildTree(2*i+1, si, mid, arr);
        buildTree(2*i+2, mid+1, sj, arr);

        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]); // use Math.min for minimum
            
    }


    public static int getMin(int arr[], int qi, int qj) { // Use getMin for minimum
        int n = arr.length;
        return getMinUtil(0, 0, n-1, qi, qj);
    }

    

    public static int getMinUtil(int i, int si, int sj, int qi, int qj) {
        // No Overlap
        if (si > qj || sj < qi) {
            return Integer.MAX_VALUE;    // use Integer.MAX_VALUE for minimum
            }
        // Complete Overlap
        if (si >= qi && sj <= qj) {
            return tree[i];
            }
            // Partial Overlap
            int mid = (si + sj)/2;
            int left = getMinUtil(2*i+1, si, mid, qi, qj);
            int right = getMinUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.min(left, right);   // use Math.min for minimum
    }


    public static void update(int arr[], int idx, int newVal) { //This function updates only index,
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal) { //This function updates complete in Segment tree.
        if(idx < si || idx > sj) {
            return;
        }
        if(si == sj) {
            tree[i] = newVal;
        }

        if(si != sj) {
            tree[i] = Math.min(tree[i], newVal);
            int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal); //left
            updateUtil(2*i+2, mid+1, sj, idx, newVal); //right
        }
        
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        initalize(n);
        buildTree(0, 0, n-1, arr);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        int min = getMin(arr, 2, 5);  //use getMin for minimum
        System.out.println(min);

        update(arr, 2, 20);

        min = getMin(arr, 2, 5);   //use getMin for minimum
        System.out.println(min);
    }
    
}
