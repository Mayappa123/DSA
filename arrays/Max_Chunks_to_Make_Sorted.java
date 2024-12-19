public class Max_Chunks_to_Make_Sorted {
    public static int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        System.out.println(maxChunksToSorted(arr));
    }
}