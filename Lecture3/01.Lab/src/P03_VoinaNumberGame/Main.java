package P03_VoinaNumberGame;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        int[] playerOneNums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] playerTwoNums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 20; i++) {
            firstPlayerCards.add(playerOneNums[i]);
        }

        for (int i = 0; i < 20; i++) {
            secondPlayerCards.add(playerTwoNums[i]);
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                if (firstPlayerCards.size() == secondPlayerCards.size()) {
                    System.out.println("Draw!");

                    return;
                }

                System.out.println(firstPlayerCards.size() > secondPlayerCards.size() ?
                        "First player win!" : "Second player win!");

                return;
            }

            int firstNum = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNum);
            int secondNum = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNum);

            if (firstNum > secondNum) {
                firstPlayerCards.add(secondNum);
                firstPlayerCards.add(firstNum);

            } else if (firstNum < secondNum) {
                secondPlayerCards.add(firstNum);
                secondPlayerCards.add(secondNum);

            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
