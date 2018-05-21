package P01_ParkingLot;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> cars = new HashSet<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] input = line.split(", ");

            String cmd = input[0];
            String carPlate = input[1];

            if ("IN".equals(cmd)) {
                cars.add(carPlate);
            } else {
                cars.remove(carPlate);
            }

        }

        if (!cars.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), cars));
        } else {
            System.out.println("Parking Lot is Empty");
        }


    }
}
