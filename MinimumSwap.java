class MinimumSwap {
    public static int Swap(int num) {
        char[] numbers = Integer.toString(num).toCharArray();

        int[] arr = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i] - '0'] = i;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 9; j > numbers[i] - '0'; j--) {
                if (arr[j] > i) {

                    char temp = numbers[i];
                    numbers[i] = numbers[arr[j]];
                    numbers[arr[j]] = temp;

                    return Integer.parseInt(new String(numbers));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int num = 5809;
        System.out.println(Swap(num));
    }
}