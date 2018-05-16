package T9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfNumbers = scanner.nextInt();

        int[] numbers = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        String line;
        while (!("party over".equals(line = scanner.nextLine()))) {
            String[] tokens = line.split("\\s+");
            int pattern =
        }
    }
}
