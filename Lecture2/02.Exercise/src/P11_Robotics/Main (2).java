package P11_Robotics;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsTokens = scanner.nextLine().split(";");
        String[] robots = new String[robotsTokens.length];
        int[] processTimes = new int[robotsTokens.length];
        int[] robotsCounter = new int[robotsTokens.length];

        for (int i = 0; i < robotsTokens.length; i++) {
            String[] robotsToken = robotsTokens[i].split("-");
            robots[i] = robotsToken[0];
            processTimes[i] = Integer.parseInt(robotsToken[1]);
        }

        String[] time = scanner.nextLine().split(":");
        long h = Integer.parseInt(time[0]) * 60 * 60;
        long m = Integer.parseInt(time[1]) * 60;
        long s = Integer.parseInt(time[2]);
        long seconds = h + m + s;

        ArrayDeque<String> products = new ArrayDeque<>();

        String product = "";
        while (!"End".equals(product = scanner.nextLine())) {
            products.add(product);
        }

        while (!products.isEmpty()) {
            seconds++;

            for (int i = 0; i < robots.length; i++) {
                if (robotsCounter[i] > 0) {
                    robotsCounter[i]--;
                }
            }

            String currProduct = products.poll();
            boolean isProductTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (robotsCounter[i] == 0) {
                    robotsCounter[i] = processTimes[i];
                    isProductTaken = true;
                    System.out.printf("%s - %s [%s]%n", robots[i], currProduct, convertSecondsToHMmSs(seconds));
                    break;
                }
            }

            if (!isProductTaken) {
                products.add(currProduct);
            }
        }
    }

    private static String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", h, m, s);
    }
}

