package P03_Ascent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> decodedWords = new HashMap<>();

        Pattern pattern = Pattern.compile("([,_])(?<lettter>[a-zA-Z]+?)(?<numbers>[\\d])");
        while (true) {
            String input = reader.readLine();
            if (input.equals("Ascend")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                String oldValue = matcher.group();
                int number = Integer.parseInt(matcher.group("numbers"));

                char[] letters = matcher.group("lettter").toCharArray();
                String manipulation = matcher.group(1);
                String newValue = "";

                switch (manipulation) {
                    case "_":
                        decryptWith_(number, letters);
                        newValue = String.copyValueOf(letters);
                        break;
                    case ",":
                        decryptWithDot(number, letters);
                        newValue = String.copyValueOf(letters);
                        break;

                }
                input = input.replaceAll(oldValue, newValue);
                matcher = pattern.matcher(input);
            }
            System.out.println(input);
        }
    }

    private static void decryptWithDot(int numbers, char[] letters) {
        for (int j = 0; j < letters.length; j++) {
            letters[j] += numbers;
        }
    }

    private static void decryptWith_(int numbers, char[] letters) {
        for (int j = 0; j < letters.length; j++) {
            letters[j] -= numbers;
        }
    }
}

