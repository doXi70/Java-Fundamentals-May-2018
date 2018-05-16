//public class Test {
//    public static void main(String[] args) {
//        /*
//            Check what bit is at position - p of a number - n.
//         */
//        int n = 291;               // 00000001 00100011
//        int p = 5;
//
//        int mask = n >> p;         // 00000000 00001001
//        int bit = mask & 1;        // 00000000 00000001
//
//        System.out.println(bit);   // 1
//
//
//
//        /*
//            How to set the bit at position p to 0.
//         */
//
//        int n = 291;               // 00000001 00100011
//        int p = 5;
//        int mask2 = ~(1 << p);      // 11111111 11011111
//        int result1 = n & mask2;     // 00000001 00000011
//        System.out.println(result1); // 259
//
//
//
//         /*
//            How to set the bit at position p to 1.
//         */
//        int num = 291;                // 00000001 00100011
//        int pos = 4;
//        int mask3 = 1 << pos;          // 00000000 00010000
//        int result2 = num | mask3;      // 00000001 00110011
//        System.out.println(result2);  // 307
//
//
//        // 000000000000000000000000000000010000
//
////        int arr[] = {44, 106, 12};
////        int pozition = 0;
////
////        for (int i = 0; i < arr.length; i++) {
////            int num = arr[i];
////            int mask = ~(1 << pozition);
////            arr[i] = num & mask;
////        }
////
////        for (int i = 0; i < arr.length; i++) {
////            int i1 = arr[i];
////            System.out.print(i1 + " ");
////        }
//    }
//}
