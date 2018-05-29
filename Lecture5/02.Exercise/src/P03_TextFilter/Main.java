package P03_TextFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] banWords = reader.readLine().split(", ");
        String inputText = reader.readLine();

        for (String banWord : banWords) {
            inputText = inputText.replace(banWord, replaceWordWithSymbol(banWord, '*'));
        }

        System.out.println(inputText);
    }

    private static String replaceWordWithSymbol(String word, char symbol) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            sb.append(symbol);
        }

        return sb.toString();
    }
}
