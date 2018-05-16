package L6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine();
        double price;

        if (n < 20) {
            if ("day".equals(dayNight)) {
                price = 0.79 * n + 0.7;
            } else {
                price = 0.9 * n + 0.7;
            }
        } else if (n < 100) {
            price = 0.09 * n;
        } else {
            price = 0.06 * n;
        }

        System.out.printf("%.2f", price);
    }
}
