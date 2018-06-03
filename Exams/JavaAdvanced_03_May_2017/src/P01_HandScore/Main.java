package P01_HandScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> cards = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        System.out.println(calculateCardsSum(cards));
    }

    private static int calculateCardsSum(List<String> cards) {
        if (cards.get(0).isEmpty()) return 0;

        int totalHandSum = 0;
        int multiplier = 1;
        int currHandSum = 0;

        for (int i = 0; i < cards.size(); i++) {
            char currCardType = getCardType(cards.get(i));
            if (i + 1 == cards.size()) {
                if (multiplier == 1) {
                    totalHandSum += getCardNumber(cards.get(i));
                } else {
                    currHandSum += getCardNumber(cards.get(i));
                    currHandSum *= multiplier;

                    totalHandSum += currHandSum;
                }

                break;
            }
            char nextCardType = getCardType(cards.get(i + 1));

            if (currCardType == nextCardType) {
                currHandSum += getCardNumber(cards.get(i));
                multiplier++;
            } else {
                if (currHandSum == 0) {
                    totalHandSum += getCardNumber(cards.get(i));
                } else {
                    currHandSum += getCardNumber(cards.get(i));
                    currHandSum *= multiplier;

                    totalHandSum += currHandSum;
                }

                currHandSum = 0;
                multiplier = 1;
            }

        }

        return totalHandSum;
    }

    private static char getCardType(String s) {
        return s.length() == 2 ? s.charAt(1) : s.charAt(2);
    }

    private static int getCardNumber(String card) {
        String num = card.length() == 2 ? card.substring(0, 1) : card.substring(0, 2);

        if (!(num.equals("J") || num.equals("Q") ||
                num.equals("K") || num.equals("A"))) {
            return Integer.parseInt(num);
        } else {
            switch (num) {
                case "A":
                    return 15;
                case "K":
                    return 14;
                case "Q":
                    return 13;
                default:
                    return 12;
            }
        }
    }
}
