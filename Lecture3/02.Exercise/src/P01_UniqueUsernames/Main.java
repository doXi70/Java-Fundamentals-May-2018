package P01_UniqueUsernames;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();

        int userCount = Integer.parseInt(scanner.nextLine());

        String line;
        for (int i = 0; i < userCount; i++) {
            usernames.add(line = scanner.nextLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
