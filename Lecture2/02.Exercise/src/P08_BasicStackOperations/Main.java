package P08_BasicStackOperations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cmds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int countToPush = cmds[0];
        int countToPop = cmds[1];
        int numToCheckIfPresent = cmds[2];

        int[] inputNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countToPush; i++) {
            stack.push(inputNums[i]);
        }



        while (countToPop-- != 0) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.contains(numToCheckIfPresent)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
