package P12_ExtractEmails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        String userNamePattern = "(^|\\s)[\\dA-Za-z][\\w-.]+?[\\dA-Za-z]";
        String hostPattern = "[A-Za-z][A-Za-z-.]*?(\\.[A-Za-z-.]*?[A-Za-z]+)+";

        String input = reader.readLine();

        Pattern pattern = Pattern.compile(userNamePattern + "@" + hostPattern);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}
