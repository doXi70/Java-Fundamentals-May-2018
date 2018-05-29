package P04_UnicodeCharacters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();

        for (char currChar : input) {
            System.out.print(toUnicode(currChar));
        }

    }

    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
