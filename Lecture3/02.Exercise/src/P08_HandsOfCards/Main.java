package P08_HandsOfCards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String line;
        while (!"JOKER".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(": ");

            String playerName = tokens[0];
            String[] cards = tokens[1].split(", ");
            Set<String> uniqeCarts = processCards(cards);

            if (players.containsKey(playerName)) {
                uniqeCarts.addAll(players.get(playerName));
                players.put(playerName, uniqeCarts);
            } else {
                players.put(playerName, uniqeCarts);
            }

        }

        processCardValues(players);
    }

    private static void processCardValues(Map<String, Set<String>> players) {
        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            long cardPower = calcCardsSum(cards);

            System.out.printf("%s: %d%n", name, cardPower);
        }
    }

    private static long calcCardsSum(Set<String> cards) {
        long totalSum = 0;
        for (String card : cards) {
            int powerInNum = cardPower(card.substring(0, card.length() - 1));
            int typeInNum = cardType(card.substring(card.length() - 1));
            totalSum += powerInNum * typeInNum;
        }

        return totalSum;
    }

    private static int cardType(String type) {
        int num = 0;

        if ("S".equals(type)) {
            num = 4;
        } else if ("H".equals(type)) {
            num = 3;
        } else if ("D".equals(type)) {
            num = 2;
        } else {
            num = 1;
        }

        return num;
    }

    private static Set<String> processCards(String[] cards) {
        Set<String> result = new HashSet<>();
        Collections.addAll(result, cards);

        return result;
    }

    private static int cardPower(String power) {
        int powerInNum = 0;

        switch (power) {
            case "2":
                powerInNum = 2;
                break;
            case "3":
                powerInNum = 3;
                break;
            case "4":
                powerInNum = 4;
                break;
            case "5":
                powerInNum = 5;
                break;
            case "6":
                powerInNum = 6;
                break;
            case "7":
                powerInNum = 7;
                break;
            case "8":
                powerInNum = 8;
                break;
            case "9":
                powerInNum = 9;
                break;
            case "10":
                powerInNum = 10;
                break;
            case "J":
                powerInNum = 11;
                break;
            case "Q":
                powerInNum = 12;
                break;
            case "K":
                powerInNum = 13;
                break;
            case "A":
                powerInNum = 14;
                break;
        }

        return powerInNum;
    }
}
