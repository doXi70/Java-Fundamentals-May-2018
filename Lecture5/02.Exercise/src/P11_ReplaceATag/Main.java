package P11_ReplaceATag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder inputText = new StringBuilder();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            inputText.append(line).append(System.lineSeparator());
        }

        String text = inputText.toString();
        Pattern regexPattern = Pattern.compile("(<a)\\s+href[^>]+(>)\\s*.*?(</a>)");
        Matcher matcher = regexPattern.matcher(text);

        while (matcher.find()) {
            String fullMatch = matcher.group(0);
            String openATag = matcher.group(1);
            String bracket = matcher.group(2);
            String closingATag = matcher.group(3);

            String replacement = fullMatch.replaceFirst(openATag, "[URL")
                    .replaceFirst(bracket, "]")
                    .replaceFirst(closingATag, "[/URL]");

            text = text.replace(fullMatch, replacement);
        }

        System.out.println(text);
    }
}