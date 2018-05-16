package T8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToLong(Long::parseLong).toArray();

        String[] inputCommand = scanner.nextLine().split("\\s+");
        int getNumbers = Integer.parseInt(inputCommand[1]);

        int takenNumsCount = 0;
        for (long token : tokens) {
            if (takenNumsCount == getNumbers) {
                break;
            }

            switch (inputCommand[2].toLowerCase()) {
                case "odd":
                    if (isOdd(token)) {
                        System.out.print(token + " ");
                        takenNumsCount++;
                    }
                    break;
                case "even":
                    if (!isOdd(token)) {
                        System.out.print(token + " ");
                        takenNumsCount++;
                    }
                    break;
            }
        }

    }

    private static boolean isOdd(long element) {
        return element % 2 != 0;
    }


}
