public class Practice {
    public static void main(String[] args) {
        int arr[] = {0, 1, 12};
        int position = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int mask = 1 << position;
            arr[i] = num ^ mask;
        }


        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(i1 + " ");
        }
    }
}
