package P02_SetsOfElements;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setDimentions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int firstSetLen = setDimentions[0];
        int secondSetLen = setDimentions[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> sameNums = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLen; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < secondSetLen; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        int minLen = Math.min(firstSetLen, secondSetLen);
        for (int i = 0; i < minLen; i++) {
            if (firstSet.isEmpty()) {
                break;
            }

            int num = firstSet.iterator().next();
            if (secondSet.contains(num)) {
                sameNums.add(num);
            }
            firstSet.remove(num);
        }

        for (Integer sameNum : sameNums) {
            System.out.print(sameNum + " ");
        }
    }

}