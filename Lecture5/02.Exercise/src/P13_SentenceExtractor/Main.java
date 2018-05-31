package P13_SentenceExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));


        String keyWord = reader.readLine();
        String text = reader.readLine();

        String pattern = ".*?[.!?]";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            String foundMatch = matcher.group(0).trim();
            if (containsKeyWord(foundMatch, keyWord)) {
                System.out.println(foundMatch);
            }
        }


    }

    private static boolean containsKeyWord(String foundMatch, String keyWord) {
        String[] words = foundMatch.split("\\s+");

        for (String word : words) {
            if (word.equals(keyWord)) {
                return true;
            }
        }

        return false;
    }
}
