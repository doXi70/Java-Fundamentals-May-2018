package P11_Robotics;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//        Time t =

public class Main {
    private static int startWorkTimeHour;
    private static int startWorkTimeMin;
    private static int startWorkTimeSec;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[-;]+");
        Map<String, String> robotics = new LinkedHashMap<>();
        fillMap(robotics, input);

        int[] startWorkTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        startWorkTimeHour = startWorkTime[0];
        startWorkTimeMin = startWorkTime[1];
        startWorkTimeSec = startWorkTime[2];


    }

    private static void fillMap(Map<String, String> robotics, String[] input) {
        for (int i = 0; i < input.length; i += 2) {
            String robotName = input[i];
            String processTime = input[i + 1];

            robotics.put(robotName, processTime);
        }
    }

    private static void logWork() {

    }
}
