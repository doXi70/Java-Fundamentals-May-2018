package P03_FormattingNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.println(printLeftAlign(a) + printBinary(a) + printRightAllign(b) + leftAlignThreeDigits(c));

    }

    // 254 11,6 0,5
    // 0011111110
    private static String printLeftAlign(int a) {
        String aToString = String.valueOf(Integer.toHexString(a));

        StringBuilder sb = new StringBuilder("|" + aToString.toUpperCase());
        int addSpaces = 10 - aToString.length();

        for (int i = 0; i < addSpaces; i++) {
            sb.append(" ");
            if (i == addSpaces - 1) {
                sb.append("|");
            }
        }

        return sb.toString();
    }

    private static String printBinary(int a) {
        String aToBinary = Integer.toBinaryString(a);
        StringBuilder sb = new StringBuilder("");

        int zeros = 10 - aToBinary.length();

        for (int i = 0; i < zeros; i++) {
            sb.append("0");
        }


        return sb.append(aToBinary + "|").toString();
    }

    private static String printRightAllign(double b) {
        StringBuilder sb = new StringBuilder("");
        String rounded = String.format("%.2f", b);
        int spaces = 10 - rounded.length();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }

        return sb.append(rounded + "|").toString().replace(",", ".");
    }

    private static String leftAlignThreeDigits(double b) {
        String formated = String.format("%.3f", b);
        StringBuilder sb = new StringBuilder(formated);
        int spaces = 10 - sb.length();

        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }

        return sb.append("|").toString().replace(",",".");
    }
}
