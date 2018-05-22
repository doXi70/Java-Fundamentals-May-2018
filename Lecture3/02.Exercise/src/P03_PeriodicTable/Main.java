package P03_PeriodicTable;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> uniqeElements = new TreeSet<>();

        for (int i = 0; i < numOfCompounds; i++) {
            String[] chemicalElements = scanner.nextLine().split(" ");
            Collections.addAll(uniqeElements, chemicalElements);
        }

        for (String uniqeElement : uniqeElements) {
            System.out.print(uniqeElement + " ");
        }
    }
}