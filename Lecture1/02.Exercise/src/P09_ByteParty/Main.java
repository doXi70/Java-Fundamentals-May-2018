package P09_ByteParty;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfNumbers = Integer.parseInt(scanner.nextLine());
        int[] tokens = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            tokens[i] = Integer.parseInt(scanner.nextLine());
        }

        String line;
        while (!("party over".equals(line = scanner.nextLine()))) {
            int[] cmds = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            switch (cmds[0]) {
                case -1:
                    flipBitAtPosition(tokens, cmds[1]);
                    break;
                case 0:
                    setBitAtPositionToBeZero(tokens, cmds[1]);
                    break;
                case 1:
                    setBitAtPositionToBeOne(tokens, cmds[1]);
                    break;
            }
        }

        for(int number : tokens) {
            System.out.println(number);
        }
    }

    private static void flipBitAtPosition(int[] arr, int position) {
        for (int i = 0; i < arr.length; i++) {
            int currNumber = arr[i];
            int mask = 1 << position;
            arr[i] = currNumber ^ mask;
        }
    }

    private static void setBitAtPositionToBeZero(int arr[], int position) {
        for (int i = 0; i < arr.length; i++) {
            int currNumber = arr[i];
            int mask = ~(1 << position);
            arr[i] = currNumber & mask;
        }
    }

    private static void setBitAtPositionToBeOne(int arr[], int position) {
        for (int i = 0; i < arr.length; i++) {
            int currNumber = arr[i];
            int mask = 1 << position;
            arr[i] = currNumber | mask;
        }
    }
}
