package P11_GameOfNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPLayers = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> players = new HashMap<>();

        for (int i = 0; i < countOfPLayers; i++) {
            String playerName = scanner.nextLine();
            int initPoints = Integer.parseInt(scanner.nextLine());

            players.put(playerName, initPoints);
        }


        String winnerName = "";
        int maxPoints = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> stringIntegerEntry : players.entrySet()) {
            String name = stringIntegerEntry.getKey();
            Integer points = stringIntegerEntry.getValue();

            int currPlayerPoints = calcTotalPlayerPoints(name, points);
            if (currPlayerPoints > maxPoints) {
                maxPoints = calcTotalPlayerPoints(name, points);
                winnerName = name;
            }

        }

        System.out.printf("The winner is %s - %d points", winnerName, maxPoints);
    }

    private static int calcTotalPlayerPoints(String name, Integer points) {
        int totalScore = points;

        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) % 2 == 0) {
                totalScore += name.charAt(i);
            } else {
                totalScore -= name.charAt(i);
            }
        }

        return totalScore;
    }
}
