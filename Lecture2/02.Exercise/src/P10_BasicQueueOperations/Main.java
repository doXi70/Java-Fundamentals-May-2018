package P10_BasicQueueOperations;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int countAdd  = input[0];
        int countPull = input[1];
        int elementCheck = input[2];

//        int[] startNums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < countAdd; i++) {
            int num = scanner.nextInt();
            deque.add(num);
        }

        while (countPull-- != 0) {
            if(deque.isEmpty()) {
                System.out.println("0");
                return;
            }

            deque.remove();
        }

        if(deque.isEmpty()) {
            System.out.println("0");
            return;
        }


        if(deque.contains(elementCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(deque));
        }
    }
}
