package P07_CharacterMultiplier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        int minLen = Math.min(str1.length(), str2.length());
        long sum = 0;

        int currentIndexPosition = 0;
        for (int i = 0; i < minLen; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
            currentIndexPosition = i;
        }


        int diff = Math.max(str1.length(), str2.length()) - minLen;

        while (diff-- > 0) {
            if (str1.length() > str2.length()) {
                sum += str1.charAt(++currentIndexPosition);
            } else {
                sum += str2.charAt(++currentIndexPosition);
            }
        }

        System.out.println(sum);
    }
}
