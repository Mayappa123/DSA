public class Final_Array_State_after_K_Multiplication_Operation {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = 0;

            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            nums[min] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        
    }
}
