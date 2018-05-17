package P01_EncryptSortAndPrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
    Left padding v string-a za vodeshtite nuli.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfInput = Integer.parseInt(scanner.nextLine());

        List<String> inputData = new ArrayList<>();


        for (int i = 0; i < countOfInput; i++) {
            inputData.add(scanner.nextLine());
        }

        int[] result = encryptData(inputData);
        Arrays.sort(result);

        printArr(result);
    }

    private static void printArr(int[] result) {
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] encryptData(List<String> data) {
        int[] encryptedData = new int[data.size()];

        for (int i = 0; i < data.size(); i++) {
            String currString = data.get(i);
            int totalSum = 0;

            for (int j = 0; j < currString.length(); j++) {
                if (isVowel(currString.charAt(j))) {
                    totalSum += currString.charAt(j) * currString.length();
                } else {
                    totalSum += currString.charAt(j) / currString.length();
                }
            }

            encryptedData[i] = totalSum;
        }

        return encryptedData;
    }

    private static boolean isVowel(char a) {
        String toLower = String.valueOf(a).toLowerCase();

        return toLower.equals("a") || toLower.equals("e") || toLower.equals("i")
                || toLower.equals("o") || toLower.equals("u");
    }
}
