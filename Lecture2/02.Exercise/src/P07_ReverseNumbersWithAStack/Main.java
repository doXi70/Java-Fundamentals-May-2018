package P07_ReverseNumbersWithAStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .sorted(Comparator.reverseOrder())
//                .forEach(x -> System.out.print(x + " "));

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int anInput : input) {
            stack.push(anInput);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.pop() + " ");
        }
    }
}
