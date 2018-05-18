package P05_OddAndEvenPairs;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        if (tokens.length % 2 == 0) {
            for (int i = 0; i < tokens.length; i += 2) {
                if (isOdd(tokens[i]) && isOdd(tokens[i + 1])) {
                    System.out.printf("%d, %d -> both are odd%n", tokens[i], tokens[i + 1]);
                } else if (isEven(tokens[i]) && isEven(tokens[i + 1])) {
                    System.out.printf("%d, %d -> both are even%n", tokens[i], tokens[i + 1]);
                } else {
                    System.out.printf("%d, %d -> different%n", tokens[i], tokens[i + 1]);
                }
            }
        } else {
            System.out.println("invalid length");
        }
    }

    private static boolean isOdd(int token) {
        return token % 2 != 0;
    }

    private static boolean isEven(int token) {
        return token % 2 == 0;
    }
}
