package T2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();

        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();

        double cx = scanner.nextDouble();
        double cy = scanner.nextDouble();

        double area = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2;

        if(area == 0) {
            System.out.println(0);
        } else {
            int roundedAreaToInt = (int) area;
            System.out.println(Math.abs(roundedAreaToInt));
        }



    }
}
