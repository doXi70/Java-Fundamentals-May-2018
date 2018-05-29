package P01_CountSubstringOccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = reader.readLine().toLowerCase();
        String toMatch = reader.readLine().toLowerCase();

        int counter = 0;
        int lengthToMatch = toMatch.length();
        for (int i = 0; i < inputText.length() - lengthToMatch + 1; i++) {
            String textFromInput = inputText.substring(i, lengthToMatch + i);
            if (textFromInput.equals(toMatch)) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}