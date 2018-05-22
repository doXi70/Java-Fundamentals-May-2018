package P07_FixEmail;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> namesEmails = new LinkedHashMap<>();

        String line;
        while (!"stop".equals(line = scanner.nextLine())) {
            String name = line;
            String email = scanner.nextLine();

            String emailExtention = email.substring(email.length() - 3).toLowerCase();
            if (!(emailExtention.equals(".us") || emailExtention.equals(".uk") || emailExtention.equals("com"))) {
                namesEmails.put(name, email);
            }
        }

        for (Map.Entry<String, String> entry : namesEmails.entrySet()) {
            String name = entry.getKey();
            String email = entry.getValue();

            System.out.printf("%s -> %s%n", name, email);
        }
    }
}

/*
          Tasks
    1. Stack and Queue
    2. Matrix + Lists
    3. Regex
    4. Set and Maps
 */
