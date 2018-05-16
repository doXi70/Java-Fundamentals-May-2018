package L2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        for (int i = 0; i <= 2; i++) {
            sum += scanner.nextDouble();
        }

        System.out.printf("%.2f", sum / 3);
    }
}
