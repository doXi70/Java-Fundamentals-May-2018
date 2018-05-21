package P04_CountSameValuesInArray;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> numbers = new HashMap<>();

        String[] values = scanner.nextLine().split(" ");

        for (String number : values) {
            if (!numbers.containsKey(number)) {
                numbers.put(number, 1);
            } else {
                numbers.put(number, numbers.get(number) + 1);
            }
        }

        DecimalFormat df = new DecimalFormat("#.###################");
        for (Map.Entry<String, Integer> nums : numbers.entrySet()) {
            String number = nums.getKey();
            Integer count = nums.getValue();

            System.out.printf("%s - %d times%n", number, count);
        }
    }
}
