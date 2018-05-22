package P04_CountSymbols;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> occurences = new TreeMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (!occurences.containsKey(c)) {
                occurences.put(c, 1);
            } else {
                occurences.put(c, occurences.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> occurence : occurences.entrySet()) {
            Character key = occurence.getKey();
            Integer value = occurence.getValue();

            System.out.printf("%s: %d time/s%n", key, value);
        }
    }
}
