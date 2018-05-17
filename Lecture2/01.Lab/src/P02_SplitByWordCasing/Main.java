package P02_SplitByWordCasing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[.!,/()'\\\\\";:\\[\\] ]");

        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();

        for (String currWord : words) {
            if (isLowerCaseWord(currWord)) {
                lowerCaseWords.add(currWord);
            } else if (isUpperCaseWord(currWord)) {
                upperCaseWords.add(currWord);
            } else if (!currWord.isEmpty()) {
                mixedCaseWords.add(currWord);
            }
        }

        System.out.println("Lower-case: " + String.join(", ", lowerCaseWords));
        System.out.println("Mixed-case: " + String.join(", ", mixedCaseWords));
        System.out.println("Upper-case: " + String.join(", ", upperCaseWords));

    }

    private static boolean isUpperCaseWord(String currWord) {
        if (currWord.isEmpty()) {
            return false;
        }

        String currWordToUpper = currWord.toUpperCase();

        for (int i = 0; i < currWord.length(); i++) {
            if (currWord.charAt(i) != currWordToUpper.charAt(i) || !(Character.isLetter(currWord.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isLowerCaseWord(String currWord) {
        if (currWord.isEmpty()) {
            return false;
        }

        String currWordToLower = currWord.toLowerCase();

        for (int i = 0; i < currWord.length(); i++) {
            if (currWord.charAt(i) != currWordToLower.charAt(i) || !(Character.isLetter(currWord.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
