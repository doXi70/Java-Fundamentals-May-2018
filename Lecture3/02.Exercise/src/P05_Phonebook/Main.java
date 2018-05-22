package P05_Phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();

        String line;
        while (!"search".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phoneBook.put(name, phoneNumber);
        }

        while (!"stop".equals(line = scanner.nextLine())) {
            if (phoneBook.containsKey(line)) {
                System.out.printf("%s -> %s%n", line, phoneBook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.%n", line);
            }
        }
    }
}
