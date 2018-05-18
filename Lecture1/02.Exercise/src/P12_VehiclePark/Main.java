package P12_VehiclePark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final char CAR_SYMBOL = 'c';
    private static final char BUS_SYMBOL = 'b';
    private static final char VAN_SYMBOL = 'v';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vehiclesCount = 0;
        String[] inputData = scanner.nextLine().split("\\s+");
        List<String> vehicles = new ArrayList<>();
        Collections.addAll(vehicles, inputData);

        String line;
        while (!"End of customers!".equals(line = scanner.nextLine())) {
            String[] command = line.toLowerCase().split("\\s+");

            switch (command[0].toLowerCase().charAt(0)) {
                case CAR_SYMBOL:
                    if (vehicleExists(vehicles, CAR_SYMBOL, Integer.parseInt(command[2]))) {
                        int carPrice = CAR_SYMBOL * Integer.parseInt(command[2]);
                        System.out.printf("Yes, sold for %d$%n", carPrice);
                        vehiclesCount++;
                    } else {
                        System.out.println("No");
                    }
                    break;
                case BUS_SYMBOL:
                    if (vehicleExists(vehicles, BUS_SYMBOL, Integer.parseInt(command[2]))) {
                        int busPrice = BUS_SYMBOL * Integer.parseInt(command[2]);
                        System.out.printf("Yes, sold for %d$%n", busPrice);
                        vehiclesCount++;
                    } else {
                        System.out.println("No");
                    }
                    break;
                case VAN_SYMBOL:
                    if (vehicleExists(vehicles, VAN_SYMBOL, Integer.parseInt(command[2]))) {
                        int vanPrice = VAN_SYMBOL * Integer.parseInt(command[2]);
                        System.out.printf("Yes, sold for %d$%n", vanPrice);
                        vehiclesCount++;
                    } else {
                        System.out.println("No");
                    }
                    break;
            }
        }

        System.out.println("Vehicles left: " + String.join(", ", vehicles));
        System.out.println("Vehicles sold: " + vehiclesCount);
    }

    private static boolean vehicleExists(List<String> vehicles, char vehicleSymbol, int seats) {
        char vehicleType;

        if (vehicleSymbol == CAR_SYMBOL) {
            vehicleType = CAR_SYMBOL;
        } else if (vehicleSymbol == BUS_SYMBOL) {
            vehicleType = BUS_SYMBOL;
        } else {
            vehicleType = VAN_SYMBOL;
        }

        String vehicleToSell = vehicleType + "" + seats;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).equals(vehicleToSell)) {
                vehicles.remove(i);
                return true;
            }
        }

        return false;
    }

}
