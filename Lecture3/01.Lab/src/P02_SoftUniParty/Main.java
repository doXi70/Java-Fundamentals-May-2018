package P02_SoftUniParty;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();


        String line;
        while (!"PARTY".equals(line = scanner.nextLine())) {
            guests.add(line);
        }

        while (!"END".equals(line = scanner.nextLine())) {
            guests.remove(line);
        }

        System.out.println(guests.size());
        System.out.print(String.join(System.lineSeparator(), guests));
    }
}
