package P02_LetterExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.#######");

        String input = reader.readLine();

        Pattern numberPattern = Pattern.compile("(-?[\\d]+\\.*[\\d]*)");
        Pattern symbolsPattern = Pattern.compile("(?!([\\d]+\\.*[\\d]))([^\\d.]+)(?<!([\\d]\\.[\\d]))");

        Matcher numberMatcher = numberPattern.matcher(input);
        Matcher symbolsMatcher = symbolsPattern.matcher(input);

        double totalSum = 0;

        Queue<Double> numbers = new ArrayDeque<>();
        Queue<String> signs = new ArrayDeque<>();
        while (numberMatcher.find()) {
            numbers.add(Double.parseDouble(numberMatcher.group(1)));
        }

        while (symbolsMatcher.find()) {
            signs.add(getSign(symbolsMatcher.group(2)));
        }


        int rotation = 0;
        while (!numbers.isEmpty()) {
            double currNum = numbers.poll();

            String sign = "";
            if (!signs.isEmpty()) {
                if (signs.size() + 1 != numbers.size() && rotation == 0) {
                    sign = ((ArrayDeque<String>) signs).removeLast();
                }

                if(!signs.isEmpty())  {
                    sign = signs.poll();
                }

            }

            if (!numbers.isEmpty()) {
                if (rotation == 0) {
                    double nextNum = numbers.poll();
                    totalSum += calculateTotalSum(currNum, sign, nextNum);
                    rotation++;
                } else {
                    totalSum = calculateTotalSum(totalSum, sign, currNum);
                }
            } else {
                totalSum += calculateTotalSum(currNum, sign, 0);
            }

        }

        System.out.println(df.format(totalSum));
    }

    private static String getSign(String group) {
        return group.length() % 2 == 0 ? "+" : "-";
    }


    private static double calculateTotalSum(double currNum, String nextSign, double nextNum) {
        switch (nextSign) {
            case "+":
                return currNum + nextNum;
            case "-":
                return currNum - nextNum;
            default:
                return currNum;
        }
    }
}
